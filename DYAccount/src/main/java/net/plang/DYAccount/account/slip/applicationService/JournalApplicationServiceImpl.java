package net.plang.DYAccount.account.slip.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.dao.JournalDAO;
import net.plang.DYAccount.account.slip.dao.JournalDetailDAO;
import net.plang.DYAccount.account.slip.to.JournalBean;

public class JournalApplicationServiceImpl implements JournalApplicationService {
    private JournalDAO journalDAO;
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
            if (journalBean.getStatus().equals("insert"))
                journalDAO.insertJournal(slipNo, journalBean);

            else if (journalBean.getStatus().equals("update")) {
                boolean isChangeAccountCode = false;

                if (isChangeAccountCode) {
                    journalDetailDAO.deleteJournalDetailByJournalNo(journalBean.getJournalNo());
                    journalDetailDAO.insertJournalDetailList(journalBean.getJournalNo());
                }
            }
        }
    }

    public void setJournalDAO(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    public void setJournalDetailDAO(JournalDetailDAO journalDetailDAO) {
        this.journalDetailDAO = journalDetailDAO;
    }
}
