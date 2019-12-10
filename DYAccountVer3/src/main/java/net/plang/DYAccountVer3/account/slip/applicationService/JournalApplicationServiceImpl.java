package net.plang.DYAccountVer3.account.slip.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.account.slip.dao.JournalDAO;
import net.plang.DYAccountVer3.account.slip.dao.JournalDetailDAO;
import net.plang.DYAccountVer3.account.slip.to.JournalBean;

@Component
@Transactional
public class JournalApplicationServiceImpl implements JournalApplicationService {
	@Autowired
	private JournalDAO journalDAO;
	@Autowired
	private JournalDetailDAO journalDetailDAO;

	@Override
	public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate) {
		return journalDAO.selectRangedJournalList(fromDate, toDate);
	}

	@Override
	public ArrayList<JournalBean> findSingleJournalList(String slipNo) {
		return journalDAO.selectJournalList(slipNo);
	}

	@Override
	public void editJournal(String slipNo, ArrayList<JournalBean> journalBeanList) {
		for (JournalBean journalBean : journalBeanList) {
			if (journalBean.getStatus().equals("insert")) {
				journalBean.setSlipNo(slipNo);
				journalDAO.insertJournal(journalBean);
			}

			else if (journalBean.getStatus().equals("update")) {
				boolean isChangeAccountCode = false;

				if (isChangeAccountCode) {
					journalDetailDAO.deleteJournalDetailByJournalNo(journalBean.getJournalNo());
					journalDetailDAO.insertJournalDetailList(journalBean.getJournalNo());
				}
			}
		}
	}

}
