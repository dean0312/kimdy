package net.plang.DYAccountVer3.account.slip.controller;

import net.plang.DYAccountVer3.account.slip.serviceFacade.SlipServiceFacade;
import net.plang.DYAccountVer3.account.slip.to.JournalBean;
import net.plang.DYAccountVer3.account.slip.to.SlipBean;
import net.plang.DYAccountVer3.account.slip.to.TestBean;
import net.plang.DYAccountVer3.common.util.BeanCreator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SlipController {
	@Autowired
	private SlipServiceFacade slipServiceFacade;

	@RequestMapping(value = "account/Slip", method = RequestMethod.PUT)
	public void updateSlip(@RequestParam String slipNo, @RequestParam String slipType,
			@RequestParam String expenseReport) {
		SlipBean slipBean = new SlipBean();	

		slipBean.setSlipNo(slipNo);
		slipBean.setSlipType(slipType);
		slipBean.setExpenseReport(expenseReport);

		slipServiceFacade.updateSlip(slipBean);						

	}
	@RequestMapping(value = "account/Slip", method = RequestMethod.POST)
	public String addSlip(HttpServletRequest request) {
		System.out.println("addslip진입");
		JSONObject slipObj = JSONObject.fromObject(request.getParameter("slipObj"));
		JSONArray journalObjs = JSONArray.fromObject(request.getParameter("journalObj"));

		SlipBean slipBean = BeanCreator.getInstance().create(slipObj, SlipBean.class);
		slipBean.setReportingEmpCode(request.getSession().getAttribute("empCode").toString());
		slipBean.setDeptCode(request.getSession().getAttribute("deptCode").toString());

		ArrayList<JournalBean> journalBeans = new ArrayList<>();

		for (Object journalObj : journalObjs) {
			JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObj),
					JournalBean.class);
			journalBean.setSlipNo(slipBean.getSlipNo());
			journalBeans.add(journalBean);
		}
		
		slipServiceFacade.addSlip(slipBean, journalBeans);

		
		 
		return null;

	}

	@RequestMapping(value = "account/Slip", method = RequestMethod.DELETE)
	public void deleteSlip(@RequestParam String slipNo) {

		slipServiceFacade.deleteSlip(slipNo);

	}

//예외적으로 requestbody를사용하지않은이유는 받아온 json을  받아온 isApprove를 bean에넣을떄 for 문안에서 세터하기때문이다
	@RequestMapping(value = "account/approveSlip", method = RequestMethod.GET)
	public void approveSlip(HttpServletRequest request) {

		JSONArray approveSlipList = JSONArray.fromObject(request.getParameter("approveSlipList"));
		String slipStatus = request.getParameter("isApprove");
		ArrayList<SlipBean> slipBeans = new ArrayList<>();

		for (Object approveSlip : approveSlipList) {
			Calendar calendar = Calendar.getInstance();
			String year = calendar.get(Calendar.YEAR) + "";
			String month = "0" + (calendar.get(Calendar.MONTH) + 1);
			String date = "0" + calendar.get(Calendar.DATE);
			String today = year + "-" + month.substring(month.length() - 2) + "-" + date.substring(date.length() - 2);

			SlipBean slipBean = new SlipBean();
			slipBean.setSlipNo(approveSlip.toString());
			slipBean.setApprovalDate(today);
			slipBean.setSlipStatus(slipStatus);
			slipBeans.add(slipBean);
		}

		slipServiceFacade.approveSlip(slipBeans);

	}

	@RequestMapping(value = "account/RangedSlipList", method = RequestMethod.GET)
	public ArrayList<SlipBean> findRangedSlipList(@RequestParam String from, @RequestParam String to) {
		HashMap<String, Object> param = new HashMap<>();
		param.put("fromDate", from);
		param.put("toDate", to);

		return slipServiceFacade.findRangedSlipList(param);
	}

	@RequestMapping(value = "account/DisApprovalSlipList", method = RequestMethod.GET)
	public ArrayList<SlipBean> findDisApprovalSlipList() {

		return slipServiceFacade.findDisApprovalSlipList();

	}

}
