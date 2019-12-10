package net.plang.DYAccountVer3.account.slip.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccountVer3.account.slip.to.JournalBean;

public interface JournalServiceFacade {
    public ArrayList<JournalBean> findRangedJournalList(String fromDate, String toDate);

    public ArrayList<JournalBean> findSingleJournalList(String slipNo);

    void editJournal(String slipNo, ArrayList<JournalBean> journalBeanList);
}
