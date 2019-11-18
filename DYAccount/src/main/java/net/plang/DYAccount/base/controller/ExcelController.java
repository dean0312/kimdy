package net.plang.DYAccount.base.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.base.serviceFacade.BaseServiceFacade;
import net.plang.DYAccount.base.to.SlipExcelBean;

public class ExcelController extends MultiActionController {
	private BaseServiceFacade baseServiceFacade;

	private ModelAndView modelAndView;
	private HashMap<String,Object> modelobject;

	public ModelAndView slipExcel(HttpServletRequest request, HttpServletResponse response) {
		// SMTPAppender log4j
		modelobject=new HashMap<>();
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String viewname="null";
		try {
			List<SlipExcelBean> slipExcel = baseServiceFacade.getSlipExcelData(from, to);
			
			System.out.println("@@@@@@@@@@@@@try절안");
			modelobject.put("title","slipExcel");
			modelobject.put("list",slipExcel);
			modelobject.put("errorCode", 0);
			modelobject.put("errorMsg", "성공");
			viewname="excelView";
			
		} catch (Exception e) {
			System.out.println("@@@@@@@폭탄명"+e.getMessage());
			modelobject.clear();
			modelobject.put("errorCode", -1);
			modelobject.put("errorMsg", "다운로드 오류입니다.");
			System.out.println("@@@@@@@@@@catch절안");
			viewname="jsonView";
			throw e;
		}
		modelAndView=new ModelAndView(viewname,modelobject);
		return modelAndView;
	}

	public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}
}
