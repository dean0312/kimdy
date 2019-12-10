package net.plang.DYAccountVer3.account.slip.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccountVer3.account.slip.to.JournalDetailBean;

public interface JournalDetailServiceFacade {
    public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo);

    public void addJournalDetailList(String journalNo);

    public void editJournalDetail(JournalDetailBean journalDetailBean);
}
