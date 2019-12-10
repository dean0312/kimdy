package net.plang.DYAccountVer3.account.slip.serviceFacade;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccountVer3.account.slip.to.JournalBean;
import net.plang.DYAccountVer3.account.slip.to.SlipBean;

@SuppressWarnings("unused")
public interface SlipServiceFacade {

    public ArrayList<SlipBean> findSlipDataList(String slipDate);

    public ArrayList<SlipBean> findRangedSlipList(HashMap<String,Object> param);

    public ArrayList<SlipBean> findDisApprovalSlipList();

    public String addSlip(SlipBean slipBean, ArrayList<JournalBean> journalBeans);

    public void deleteSlip(String slipNo);

    public void updateSlip(SlipBean slipBean);

    public void approveSlip(ArrayList<SlipBean> slipBeans);
}
