package net.plang.DYAccountVer3.account.slip.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.account.slip.applicationService.JournalDetailApplicationService;
import net.plang.DYAccountVer3.account.slip.to.JournalDetailBean;

@Service
public class JournalDetailServiceFacadeImpl implements JournalDetailServiceFacade {
	@Autowired
	private JournalDetailApplicationService journalDetailApplicationService;

	@Override
	public void addJournalDetailList(String journalNo) {
		journalDetailApplicationService.addJournalDetailList(journalNo);
	}

	@Override
	public void editJournalDetail(JournalDetailBean journalDetailBean) {
		journalDetailApplicationService.editJournalDetail(journalDetailBean);
	}

	@Override
	public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo) {
		return journalDetailApplicationService.getJournalDetailList(journalNo);
	}

}
