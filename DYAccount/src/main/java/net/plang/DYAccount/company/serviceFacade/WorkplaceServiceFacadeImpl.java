package net.plang.DYAccount.company.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.company.applicationService.WorkplaceApplicationService;
import net.plang.DYAccount.company.to.WorkplaceBean;

public class WorkplaceServiceFacadeImpl implements WorkplaceServiceFacade {

	WorkplaceApplicationService workplaceApplicationService;

	public void setWorkplaceApplicationService(WorkplaceApplicationService workplaceApplicationService) {
		this.workplaceApplicationService = workplaceApplicationService;
	}

	@Override
	public void workplaceAdd(WorkplaceBean workplaceBean) {
			WorkplaceBean workplaceCodeCheck = workplaceApplicationService.getWorkplace(workplaceBean.getWorkplaceCode());
			if(workplaceCodeCheck==null) 
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