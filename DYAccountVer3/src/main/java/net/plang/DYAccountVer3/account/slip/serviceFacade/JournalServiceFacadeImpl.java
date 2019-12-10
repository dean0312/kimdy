package net.plang.DYAccountVer3.account.slip.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.account.slip.applicationService.JournalApplicationService;
import net.plang.DYAccountVer3.account.slip.to.JournalBean;

@Service
public class JournalServiceFacadeImpl implements JournalServiceFacade {
	@Autowired
	private JournalApplicationService journalApplicationService;

	@Override
	public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate) {
		return journalApplicationService.findRangedJournalList(fromDate, toDate);
	}

	@Override
	public ArrayList<JournalBean> findSingleJournalList(String slipNo) {
		
		return journalApplicationService.findSingleJournalList(slipNo);
	}

	@Override
	public void editJournal(String slipNo, ArrayList<JournalBean> journalBeanList) {
		journalApplicationService.editJournal(slipNo, journalBeanList);
	}

}
