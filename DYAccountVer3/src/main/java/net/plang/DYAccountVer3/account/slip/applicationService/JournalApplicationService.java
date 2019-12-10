package net.plang.DYAccountVer3.account.slip.applicationService;

import java.util.ArrayList;

import net.plang.DYAccountVer3.account.slip.to.JournalBean;

public interface JournalApplicationService {
    public ArrayList<JournalBean> findSingleJournalList(String slipNo);

    public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate);

    void editJournal(String slipNo, ArrayList<JournalBean> journalBeanList);
}
