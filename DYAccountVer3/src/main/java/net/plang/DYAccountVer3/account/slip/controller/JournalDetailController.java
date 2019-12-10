package net.plang.DYAccountVer3.account.slip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.plang.DYAccountVer3.account.slip.serviceFacade.JournalDetailServiceFacade;
import net.plang.DYAccountVer3.account.slip.to.JournalDetailBean;

import java.util.ArrayList;


@RestController
public class JournalDetailController {
	@Autowired
	private JournalDetailServiceFacade journalDetailServiceFacade;

	@RequestMapping(value = "account/JournalDetailList", method = RequestMethod.GET)
	public ArrayList<JournalDetailBean> getJournalDetailList(@RequestParam String journalNo) {
		ArrayList<JournalDetailBean> list=journalDetailServiceFacade.getJournalDetailList(journalNo);
		for(JournalDetailBean bean1: list) {
			System.out.println("accountcontroldescription:"+bean1.getAccountControlDescription());
			System.out.println("accountcontroltype:"+bean1.getAccountControlType());
			System.out.println("journaldescription:"+bean1.getJournalDescription());
		}
		return journalDetailServiceFacade.getJournalDetailList(journalNo);
	}

	@RequestMapping(value="account/JournalDetail",method=RequestMethod.POST)
	public void editJournalDetail(@RequestParam String journalDetailNo,@RequestParam String journalDescription) {
		JournalDetailBean journalDetailBean = new JournalDetailBean();
		System.out.println("분개상세 editjournal진입"+journalDetailNo+"  "+journalDescription);
		journalDetailBean.setJournalDetailNo(journalDetailNo);
		journalDetailBean.setJournalDescription(journalDescription);

		journalDetailServiceFacade.editJournalDetail(journalDetailBean);
	}

}
