package net.plang.DYAccountVer3.account.slip.serviceFacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.account.slip.applicationService.SlipApplicationService;
import net.plang.DYAccountVer3.account.slip.to.JournalBean;
import net.plang.DYAccountVer3.account.slip.to.SlipBean;
@Service
public class SlipServiceFacadeImpl implements SlipServiceFacade {
	@Autowired
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
    public ArrayList<SlipBean> findRangedSlipList(HashMap<String,Object> param) {
        return slipApplicationService.findRangedSlipList(param);
    }

    @Override
    public ArrayList<SlipBean> findDisApprovalSlipList() {
        return slipApplicationService.findDisApprovalSlipList();
    }

   
}
