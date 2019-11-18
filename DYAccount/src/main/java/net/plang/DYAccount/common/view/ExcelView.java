package net.plang.DYAccount.common.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import net.plang.DYAccount.base.to.SlipExcelBean;

public class ExcelView extends AbstractExcelView {
	private String[] slipTitleKo = { "전표 번호", "부서명", "적 요", "구 분", "승인상태", "작성일", "기수", "작성자명" };
	private List<String> slipTitleEn = new ArrayList<String>();

	@Override
	protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		String title = (String) map.get("title");
		System.out.println("#####TITLE:" + title);///////////////////////////////////////
		HSSFSheet sheet = null;
		try {
			if (title.equals("slipExcel")) {
				// 받아온 모델안의 title키의 value값이 "slipExcel"일경우 slipTitleEn 리스트에 빈 변수명을 담는다.(컬럼에 각각
				// 출력할 빈들을 정의하는것임.)
				slipTitleEn.add("slipno");
				slipTitleEn.add("deptname");
				slipTitleEn.add("expensereport");
				slipTitleEn.add("sliptype");
				slipTitleEn.add("slipstatus");
				slipTitleEn.add("reportingdate");
				slipTitleEn.add("accountperiodno");
				slipTitleEn.add("empname");

				List<SlipExcelBean> slipExcelList = (List<SlipExcelBean>) map.get("list");

				// controller에서 dao가서 가져온 전표정보들을 slipExcelList변수에 담는다 (map.get("list")인 이유는 가져온
				// 모델 안의 키값을 list로 controller에서 정하였기때문)

				for (SlipExcelBean bean : slipExcelList) {
					System.out.println("#####EMPLIST" + bean.getEmpName());
				}
				sheet = createSheet(workbook);
				// 시트를 만드는 메서드를 호출 workbook은 매개변수인데 무엇에 사용하는지는 모름
				createColumnLabel(sheet);
				// 위에 할당해둔 slipTitleKo멤버변수로 컬럼명을 정하는 메서드

				int rowNum = 1;
				for (SlipExcelBean appointBean : slipExcelList) {
					createSlipRow(sheet, appointBean, rowNum++);
				}
				// 빈의 갯수만큼 컬럼에 데이터를 집어넣는 작업을하는것같다

			}
		} catch (Exception e) {
			System.out.println("동영에러확인:" + e.getMessage());
		}
		/* response.setContentType("Application/Msexcel"); */
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"ATTachment; Filename=" + title + "-excel" + System.currentTimeMillis() + ".xls");
		// file이름을 정하는것같다
	}

	private HSSFSheet createSheet(HSSFWorkbook workbook) {
		// 전표 리스트라는 엑셀 시트를만드는 메서드
		System.out.println("#####엑셀시트만드는 메서드진입");
		HSSFSheet sheet = workbook.createSheet();

		workbook.setSheetName(0, "전표 리스트");

		sheet.setColumnWidth(1, (256 * 20));
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet) {
		// 컬럼에 라벨을만드는 메서드
		System.out.println("#####라벨만드는메서드 진입");
		HSSFRow row = sheet.createRow(0);

		for (int i = 0; i < slipTitleKo.length; i++) {
			// for문을돌리면서 미리 멤버변수에 세팅해둔 slipTitle(한글로된 전표컬럼명들)을 for 문에 배열길이만큼 반복해서 반복한만큼
			// 셀을만들고 그셀에 배열안value들을 세팅하는과정
			System.out.println("#####전표컬럼명들" + slipTitleKo[i]);
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(slipTitleKo[i]);
		}
	}

	private void createSlipRow(HSSFSheet sheet, SlipExcelBean slipExcelBean, int rowNum)
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HSSFRow row = sheet.createRow(rowNum);
		System.out.println("#####전표데이터넣는 메서드 진입");
		Class slipclass = Class.forName("net.plang.DYAccount.base.to.SlipExcelBean");
		// 빈클래스의 이름을 받아옴.
		Method[] methods = slipclass.getDeclaredMethods();
		// 빈클래스의 모든setter,getter메서드를 배열로 받아옴.
		int cellNum;
		for (Method method : methods) {

			String mName = method.getName();
			// 확장for문으로 빈안의 setter,getter 메서드를 String 변수에 담는다(자료형을 String으로사용해 뒤에substring을
			// 사용하기위함인듯함).
			if (mName.startsWith("get")) {
				// 담은 메서드이름들을 startsWith메서드로 앞이 get으로시작하는 메서드로 구별을한다 (getter만 사용하는것으로 보임)
				String rowTitle = mName.substring(3).toLowerCase(); // 소문자로 값을 비교한다.
				System.out.println("@#@#@#@#@#rowtitle: "+rowTitle);
				cellNum = slipTitleEn.indexOf(rowTitle);
				System.out.println("셀넘버: "+cellNum);
				if (cellNum != -1) {
					HSSFCell cell = row.createCell(cellNum);

					Object returnValue = method.invoke(slipExcelBean, null); // invoke는 호출
					System.out.println("&^%&%&%&%&returnValue:"+(String)returnValue);
					if (returnValue instanceof String) { // instanceof로 자료형을 조사한다. 스트링인지 아닌지.
						cell.setCellValue((String) returnValue);
					} else if (returnValue instanceof Integer) {
						cell.setCellValue((Integer) returnValue + "");
					}

				}

			}

		}

	}
}
