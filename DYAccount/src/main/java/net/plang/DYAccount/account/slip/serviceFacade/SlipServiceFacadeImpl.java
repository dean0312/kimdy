package net.plang.DYAccount.account.slip.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.applicationService.SlipApplicationService;
import net.plang.DYAccount.account.slip.to.JournalBean;
import net.plang.DYAccount.account.slip.to.SlipBean;

public class SlipServiceFacadeImpl implements SlipServiceFacade {
    private SlipApplicationService slipApplicationService;

    @Override
    public String addSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans) {
        return slipApplicationService.addSlip(slipBean, journalBeans);
    }

    @Override
    public void deleteSlip(String slipNo) {
        slipApplicationService.deleteSlip(slipNo);
    }

    @Override
    public void updateSlip(SlipBean slipBean) {
        slipApplicationService.updateSlip(slipBean);
    }

    @Override
    public void approveSlip(ArrayList<SlipBean> slipBeans) {
        slipApplicationService.approveSlip(slipBeans);
    }

    @Override
    public ArrayList<SlipBean> findSlipDataList(String slipDate) {
        return slipApplicationService.findSlipDataList(slipDate);
    }

    @Override
    public ArrayList<SlipBean> findRangedSlipList(String fromDate, String toDate) {
        return slipApplicationService.findRangedSlipList(fromDate, toDate);
    }

    @Override
    public ArrayList<SlipBean> findDisApprovalSlipList() {
        return slipApplicationService.findDisApprovalSlipList();
    }

    public void setSlipApplicationService(SlipApplicationService slipApplicationService) {
        this.slipApplicationService = slipApplicationService;
    }
}
