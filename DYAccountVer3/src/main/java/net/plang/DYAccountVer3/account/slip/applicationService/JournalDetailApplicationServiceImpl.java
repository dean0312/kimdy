package net.plang.DYAccountVer3.account.slip.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.account.slip.dao.JournalDetailDAO;
import net.plang.DYAccountVer3.account.slip.to.JournalDetailBean;

@Component
@Transactional
public class JournalDetailApplicationServiceImpl implements JournalDetailApplicationService {
	@Autowired
	private JournalDetailDAO journalDetailDAO;

	@Override
	public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo) {
		return journalDetailDAO.selectJournalDetailList(journalNo);
	}

	@Override
	public void addJournalDetailList(String journalNo) {
		journalDetailDAO.insertJournalDetailList(journalNo);
	}

	@Override
	public void editJournalDetail(JournalDetailBean journalDetailBean) {
		journalDetailDAO.updateJournalDetail(journalDetailBean);
	}

}
