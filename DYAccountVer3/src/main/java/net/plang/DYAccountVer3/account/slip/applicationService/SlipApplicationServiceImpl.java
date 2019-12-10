package net.plang.DYAccountVer3.account.slip.applicationService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.account.slip.dao.JournalDAO;
import net.plang.DYAccountVer3.account.slip.dao.JournalDetailDAO;
import net.plang.DYAccountVer3.account.slip.dao.SlipDAO;
import net.plang.DYAccountVer3.account.slip.to.JournalBean;
import net.plang.DYAccountVer3.account.slip.to.SlipBean;

@Component
@Transactional
public class SlipApplicationServiceImpl implements SlipApplicationService {
	@Autowired
	private SlipDAO slipDAO;
	@Autowired
	private JournalDAO journalDAO;
	@Autowired
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
		System.out.println("전표번호확인"+slipNo);
		slipBean.setSlipNo(slipNo);
		System.out.println(slipBean.getSlipNo());
		System.out.println(slipBean.getAccountPeriodNo());
		System.out.println(slipBean.getDeptCode());
		System.out.println(slipBean.getSlipType());
		System.out.println(slipBean.getExpenseReport());
		System.out.println(slipBean.getReportingEmpCode());
		System.out.println(slipBean.getReportingDate());
		System.out.println(slipBean.getSlipStatus());
		System.out.println(slipBean.getApprovalEmpCode());
		System.out.println(slipBean.getApprovalDate());
		slipDAO.insertSlip(slipBean);
    	 
		for (JournalBean journalBean : journalBeans) {
			String journalNo=(String)journalDAO.selectJournalName(slipNo);
			System.out.println("분개번호확인"+journalNo);
			journalBean.setSlipNo(slipNo);
	        journalBean.setJournalNo(journalNo);
			journalDAO.insertJournal(journalBean);
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
	public ArrayList<SlipBean> findRangedSlipList(HashMap<String,Object> param) {
		return slipDAO.selectRangedSlipList(param);
	}

	@Override
	public ArrayList<SlipBean> findDisApprovalSlipList() {
		return slipDAO.selectDisApprovalSlipList();
	}

}
