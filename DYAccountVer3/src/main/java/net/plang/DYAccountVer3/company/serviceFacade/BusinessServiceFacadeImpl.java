package net.plang.DYAccountVer3.company.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.company.applicationService.BusinessApplicationService;
import net.plang.DYAccountVer3.company.to.BusinessBean;
import net.plang.DYAccountVer3.company.to.DetailBusinessBean;

@Service
public class BusinessServiceFacadeImpl implements BusinessServiceFacade {
	@Autowired
	BusinessApplicationService businessApplicationService;

	@Override
	public ArrayList<BusinessBean> getBusinessList() {
		return businessApplicationService.getBusinessList();
	}

	@Override
	public ArrayList<DetailBusinessBean> getDetailBusiness(String businessCode) {
		return businessApplicationService.getDetailBusiness(businessCode);

	}
}
