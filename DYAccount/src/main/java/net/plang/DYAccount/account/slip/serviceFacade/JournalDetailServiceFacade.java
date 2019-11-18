package net.plang.DYAccount.account.slip.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.to.JournalDetailBean;

public interface JournalDetailServiceFacade {
    public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo);

    public void addJournalDetailList(String journalNo);

    public void editJournalDetail(JournalDetailBean journalDetailBean);
}
