package net.plang.DYAccountVer3.company.applicationService;

import java.util.ArrayList;

import net.plang.DYAccountVer3.company.to.BusinessBean;
import net.plang.DYAccountVer3.company.to.DetailBusinessBean;


public interface BusinessApplicationService {

    public ArrayList<BusinessBean> getBusinessList(); //parent 부모
	
    public ArrayList<DetailBusinessBean> getDetailBusiness(String businessName); // 1:M detail
}
