package net.plang.DYAccountVer3.company.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.company.applicationService.WorkplaceApplicationService;
import net.plang.DYAccountVer3.company.to.WorkplaceBean;

@Service
public class WorkplaceServiceFacadeImpl implements WorkplaceServiceFacade {
	@Autowired
	WorkplaceApplicationService workplaceApplicationService;

	@Override
	public void workplaceAdd(WorkplaceBean workplaceBean) {
		WorkplaceBean workplaceCodeCheck = workplaceApplicationService.getWorkplace(workplaceBean.getWorkplaceCode());
		if (workplaceCodeCheck == null)
			workplaceApplicationService.workPlaceAdd(workplaceBean);
	}

	@Override
	public void eliminationWorkplace(ArrayList<String> getCodes) {
		workplaceApplicationService.eliminationWorkplace(getCodes);
	}

	@Override
	public void updateApprovalStatus(ArrayList<String> getCodes, String status) {
		workplaceApplicationService.updateApprovalStatus(getCodes, status);
	}

	@Override
	public WorkplaceBean getWorkplace(String workplaceCode) {
		return workplaceApplicationService.getWorkplace(workplaceCode);
	}

	@Override
	public ArrayList<WorkplaceBean> getAllWorkplaceList() {
		return workplaceApplicationService.getAllWorkplaceList();
	}
}