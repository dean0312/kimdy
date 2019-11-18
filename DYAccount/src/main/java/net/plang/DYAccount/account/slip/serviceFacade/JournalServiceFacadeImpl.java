package net.plang.DYAccount.account.slip.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.applicationService.JournalApplicationService;
import net.plang.DYAccount.account.slip.to.JournalBean;

public class JournalServiceFacadeImpl implements JournalServiceFacade {
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

    public void setJournalApplicationService(JournalApplicationService journalApplicationService) {
        this.journalApplicationService = journalApplicationService;
    }
}
