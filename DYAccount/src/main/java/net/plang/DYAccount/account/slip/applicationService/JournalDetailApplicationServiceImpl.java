package net.plang.DYAccount.account.slip.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.dao.JournalDetailDAO;
import net.plang.DYAccount.account.slip.to.JournalDetailBean;

public class JournalDetailApplicationServiceImpl implements JournalDetailApplicationService {
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

    public void setJournalDetailDAO(JournalDetailDAO journalDetailDAO) {
        this.journalDetailDAO = journalDetailDAO;
    }
}
