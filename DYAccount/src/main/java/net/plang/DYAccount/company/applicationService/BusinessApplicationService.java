package net.plang.DYAccount.company.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.company.to.BusinessBean;
import net.plang.DYAccount.company.to.DetailBusinessBean;


public interface BusinessApplicationService {

    public ArrayList<BusinessBean> getBusinessList(); //parent 부모
	
    public ArrayList<DetailBusinessBean> getDetailBusiness(String businessName); // 1:M detail
}
