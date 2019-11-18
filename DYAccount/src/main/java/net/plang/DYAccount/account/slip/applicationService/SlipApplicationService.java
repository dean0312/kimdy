package net.plang.DYAccount.account.slip.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.account.slip.to.JournalBean;
import net.plang.DYAccount.account.slip.to.SlipBean;

public interface SlipApplicationService {

    public ArrayList<SlipBean> findSlipDataList(String slipDate);

    public ArrayList<SlipBean> findRangedSlipList(String fromDate, String toDate);

    public ArrayList<SlipBean> findDisApprovalSlipList();

    public String addSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans);

    public void deleteSlip(String slipNo);

    public void updateSlip(SlipBean slipBean);

    public void approveSlip(ArrayList<SlipBean> slipBeans);
}
