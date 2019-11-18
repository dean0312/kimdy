package net.plang.DYAccount.company.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.company.dao.WorkplaceDAO;
import net.plang.DYAccount.company.to.WorkplaceBean;

public class WorkplaceApplicationServiceImpl implements WorkplaceApplicationService {

	private WorkplaceDAO workplaceDAO;

	public void setWorkplaceDAO(WorkplaceDAO workplaceDAO) {
		this.workplaceDAO = workplaceDAO;
	}

	// 사업장조회
	@Override
	public WorkplaceBean getWorkplace(String workplaceCode) {
		return workplaceDAO.selectWorkplace(workplaceCode);
	}

	// 승인상태 업뎃
	@Override
	public void updateApprovalStatus(ArrayList<String> getCodes, String status) {
		for (String code : getCodes) {
			workplaceDAO.updateWorkplaceAccount(code, status);
			System.out.println(code + "업뎃완료");
		}
	}

	// 사업장추가
	@Override
	public void workPlaceAdd(WorkplaceBean workplaceBean) {
		workplaceDAO.insertWorkplace(workplaceBean);
	}

	// 사업장삭제
	@Override
	public void eliminationWorkplace(ArrayList<String> getCodes) {
		for (String code : getCodes) {
			workplaceDAO.deleteWorkplace(code);
			System.out.println("사업장삭제완료:" + code);
		}
	}

	// 사업장 승인상태 조회
	@Override
	public ArrayList<WorkplaceBean> getAllWorkplaceList() {
		return workplaceDAO.selectAllWorkplaceList();
	}
}
