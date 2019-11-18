package net.plang.DYAccount.account.slip.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import net.plang.DYAccount.account.slip.to.SlipBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

import java.util.ArrayList;
import java.util.HashMap;

public class SlipDAOImpl extends IBatisDAOSupport implements SlipDAO {

	@Override
	public ArrayList<SlipBean> selectSlipDataList(String slipDate) {
		return (ArrayList<SlipBean>) this.getSqlMapClientTemplate().queryForList("slip.selectSlipDataList", slipDate);
	}

	@Override
	public void deleteSlip(String slipNo) {
		this.getSqlMapClientTemplate().delete("slip.deleteSlip", slipNo);
	}

	@Override
	public void updateSlip(SlipBean slipBean) {
		this.getSqlMapClientTemplate().update("slip.updateSlip", slipBean);
	}

	@Override
	public void insertSlip(SlipBean slipBean) {
		this.getSqlMapClientTemplate().insert("slip.insertSlip", slipBean);
	}

	@Override
	public void approveSlip(SlipBean slipBean) {
		this.getSqlMapClientTemplate().update("slip.approveSlip", slipBean);
	}

	@Override
    public ArrayList<SlipBean> selectRangedSlipList(String fromDate, String toDate) {
		HashMap<String, String> params = new HashMap<>();
        params.put("fromDate", fromDate);
        params.put("toDate", toDate);
        try {
        return (ArrayList<SlipBean>) this.getSqlMapClientTemplate().queryForList("slip.selectRangedSlipList", params);
        }catch(EmptyResultDataAccessException e) {
        	return null;
        }
    }

	@Override
	public ArrayList<SlipBean> selectDisApprovalSlipList() { // 미승인,승인 전표 조회
		return (ArrayList<SlipBean>) this.getSqlMapClientTemplate().queryForList("slip.selectRangedSlipList");
	}

	@Override
    public int selectSlipCount(String today) {
		return (int) this.getSqlMapClientTemplate().queryForObject("slip.selectSlipCount",today);
    }
}
