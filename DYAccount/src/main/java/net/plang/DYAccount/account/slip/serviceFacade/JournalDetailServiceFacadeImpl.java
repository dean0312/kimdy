package net.plang.DYAccount.account.slip.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.applicationService.JournalDetailApplicationService;
import net.plang.DYAccount.account.slip.to.JournalDetailBean;

public class JournalDetailServiceFacadeImpl implements JournalDetailServiceFacade {
    private JournalDetailApplicationService journalDetailApplicationService;

    @Override
    public void addJournalDetailList(String journalNo) {
            journalDetailApplicationService.addJournalDetailList(journalNo);
    }

    @Override
    public void editJournalDetail(JournalDetailBean journalDetailBean) {
            journalDetailApplicationService.editJournalDetail(journalDetailBean);
    }

    @Override
    public ArrayList<JournalDetailBean> getJournalDetailList(String journalNo) {
        return journalDetailApplicationService.getJournalDetailList(journalNo);
    }

    public void setJournalDetailApplicationService(JournalDetailApplicationService journalDetailApplicationService) {
        this.journalDetailApplicationService = journalDetailApplicationService;
    }
}
