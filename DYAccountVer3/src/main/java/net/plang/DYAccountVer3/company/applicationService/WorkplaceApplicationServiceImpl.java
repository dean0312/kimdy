package net.plang.DYAccountVer3.company.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.company.dao.WorkplaceDAO;
import net.plang.DYAccountVer3.company.to.WorkplaceBean;

@Component
@Transactional
public class WorkplaceApplicationServiceImpl implements WorkplaceApplicationService {
	@Autowired
	private WorkplaceDAO workplaceDAO;

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
