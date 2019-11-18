package net.plang.DYAccount.account.slip.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.dao.JournalDAO;
import net.plang.DYAccount.account.slip.dao.JournalDetailDAO;
import net.plang.DYAccount.account.slip.dao.SlipDAO;
import net.plang.DYAccount.account.slip.to.JournalBean;
import net.plang.DYAccount.account.slip.to.SlipBean;

public class SlipApplicationServiceImpl implements SlipApplicationService {
    private SlipDAO slipDAO;
    private JournalDAO journalDAO;
    private JournalDetailDAO journalDetailDAO;

    @Override
    public ArrayList<SlipBean> findSlipDataList(String slipDate) {
        return slipDAO.selectSlipDataList(slipDate);
    }

    @Override
    public String addSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans) {
        String slipNoDate = slipBean.getReportingDate().replace("-", "");
        String slipNo = slipNoDate + "SLIP";
        String code = "0000" + (slipDAO.selectSlipCount(slipNoDate) + 1) + "";
        

        slipNo += code.substring(code.length() - 5);
        slipBean.setSlipNo(slipNo);
        
        slipDAO.insertSlip(slipBean);

        for (JournalBean journalBean : journalBeans) {
            String journalNo = journalDAO.insertJournal(slipBean.getSlipNo(), journalBean);
            journalDetailDAO.insertJournalDetailList(journalNo);
        }
        return slipNo;
    }

    @Override
    public void deleteSlip(String slipNo) {
        slipDAO.deleteSlip(slipNo);
    }

    @Override
    public void updateSlip(SlipBean slipBean) {
        slipDAO.updateSlip(slipBean);
    }

    @Override
    public void approveSlip(ArrayList<SlipBean> slipBeans) {
        for (SlipBean slipBean : slipBeans) {
            slipBean.setSlipStatus(slipBean.getSlipStatus().equals("true") ? "승인" : "반려");
            slipDAO.approveSlip(slipBean);
        }
    }

    @Override
    public ArrayList<SlipBean> findRangedSlipList(String fromDate, String toDate) {
        return slipDAO.selectRangedSlipList(fromDate, toDate);
    }

    @Override
    public ArrayList<SlipBean> findDisApprovalSlipList() {
        return slipDAO.selectDisApprovalSlipList();
    }

    public void setSlipDAO(SlipDAO slipDAO) {
        this.slipDAO = slipDAO;
    }

    public void setJournalDAO(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    public void setJournalDetailDAO(JournalDetailDAO journalDetailDAO) {
        this.journalDetailDAO = journalDetailDAO;
    }
}


