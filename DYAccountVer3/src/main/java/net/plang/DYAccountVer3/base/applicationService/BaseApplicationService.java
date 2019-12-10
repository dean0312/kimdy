package net.plang.DYAccountVer3.base.applicationService;

import java.util.ArrayList;

import net.plang.DYAccountVer3.base.exception.IdNotFoundException;
import net.plang.DYAccountVer3.base.exception.PwMissmatchException;
import net.plang.DYAccountVer3.base.to.SlipIreportBean;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

public interface BaseApplicationService {

    EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException;
    
    public ArrayList<SlipIreportBean> getIreportData(String slipNo);

}
