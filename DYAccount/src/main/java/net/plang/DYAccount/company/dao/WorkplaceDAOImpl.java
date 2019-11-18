package net.plang.DYAccount.company.dao;

import java.util.ArrayList;
import java.util.HashMap;

import net.plang.DYAccount.common.dao.IBatisDAOSupport;
import net.plang.DYAccount.company.to.WorkplaceBean;

public class WorkplaceDAOImpl extends IBatisDAOSupport implements WorkplaceDAO {

	// 사업장 조회
	@Override
	public WorkplaceBean selectWorkplace(String workplaceCode) {
		return (WorkplaceBean)this.getSqlMapClientTemplate().queryForObject("workplace.selectWorkplace", workplaceCode);
	}

	@Override // 사업장추가
	public void insertWorkplace(WorkplaceBean workplaceBean) {
		this.getSqlMapClientTemplate().insert("workplace.insertWorkplace", workplaceBean);
	}

	@Override // 거래처 미등록 사업장 조회
	public ArrayList<WorkplaceBean> selectAllWorkplaceList() {
			return (ArrayList<WorkplaceBean>)this.getSqlMapClientTemplate().queryForList("workplace.selectAllWorkplaceList");
	}

	@Override // 승인상태 업데이트
	public void updateWorkplaceAccount(String code, String status) {
		HashMap<String, String> params = new HashMap<>();
		params.put("status", status);
		params.put("code", code);
		
		this.getSqlMapClientTemplate().update("workplace.updateWorkplaceAccount", params);
	}

	@Override // 사업장삭제
	public void deleteWorkplace(String code) {
		this.getSqlMapClientTemplate().delete("workplace.deleteWorkplace", code);
	}

}
