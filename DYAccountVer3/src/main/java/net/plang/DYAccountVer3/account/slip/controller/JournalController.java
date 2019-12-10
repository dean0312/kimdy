package net.plang.DYAccountVer3.account.slip.controller;

import net.plang.DYAccountVer3.account.slip.serviceFacade.JournalServiceFacade;
import net.plang.DYAccountVer3.account.slip.to.JournalBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JournalController {
	@Autowired
	private JournalServiceFacade journalServiceFacade;

	@RequestMapping(value = "account/RangedJournalList", method = RequestMethod.GET)
	public ArrayList<JournalBean> findRangedJournalList(@RequestParam String from, @RequestParam String to) {

		return journalServiceFacade.findRangedJournalList(from, to);
	}

	@RequestMapping(value = "account/SingleJournalList", method = RequestMethod.GET)
	public ArrayList<JournalBean> findSingleJournalList(@RequestParam String slipNo) {
System.out.println("분개조회 메서드 진입");
		return journalServiceFacade.findSingleJournalList(slipNo);
	}

	@RequestMapping(value="account/Journal",method = RequestMethod.PUT)
	public void editJournal(@RequestBody ArrayList<JournalBean> journalObj, @RequestParam String slipNo) {
		/*
		 * String slipNo = request.getParameter("slipNo"); JSONArray journalObjs =
		 * JSONArray.fromObject(request.getParameter("journalObj"));
		 */
		for (JournalBean bean : journalObj) {
			System.out.println("json확인");
			System.out.println(bean.getAccountPeriodNo());
		}
		ArrayList<JournalBean> journalBeanList = journalObj;
		/*
		 * for (Object journalObj : journalObjs) { JournalBean journalBean =
		 * BeanCreator.getInstance().create(JSONObject.fromObject(journalObj),
		 * JournalBean.class); journalBean.setSlipNo(slipNo);
		 * 
		 * journalBeanList.add(journalBean); }
		 */

		 journalServiceFacade.editJournal(slipNo, journalBeanList); 

		/* modelAndView.addObject("slipNo", slipNo); */
	}

}
