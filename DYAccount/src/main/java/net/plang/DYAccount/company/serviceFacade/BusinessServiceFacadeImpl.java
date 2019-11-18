package net.plang.DYAccount.company.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.company.applicationService.BusinessApplicationService;
import net.plang.DYAccount.company.to.BusinessBean;
import net.plang.DYAccount.company.to.DetailBusinessBean;

public class BusinessServiceFacadeImpl implements BusinessServiceFacade {

	BusinessApplicationService businessApplicationService;

	public void setBusinessApplicationService(BusinessApplicationService businessApplicationService) {
		this.businessApplicationService = businessApplicationService;
	}

	@Override
	public ArrayList<BusinessBean> getBusinessList() {
		return businessApplicationService.getBusinessList();
	}

	@Override
	public ArrayList<DetailBusinessBean> getDetailBusiness(String businessCode) {
		return businessApplicationService.getDetailBusiness(businessCode);

	}
}
