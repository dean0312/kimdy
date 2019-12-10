package net.plang.DYAccountVer3.account.slip.applicationService;

import java.util.ArrayList;

import net.plang.DYAccountVer3.account.slip.to.JournalDetailBean;

public interface JournalDetailApplicationService {
    public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo);

    public void addJournalDetailList(String journalNo);

    public void editJournalDetail(JournalDetailBean journalDetailBean);
}
