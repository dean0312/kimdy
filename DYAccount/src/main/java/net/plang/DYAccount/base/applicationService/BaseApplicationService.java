package net.plang.DYAccount.base.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.base.exception.IdNotFoundException;
import net.plang.DYAccount.base.exception.PwMissmatchException;
import net.plang.DYAccount.base.to.SlipIreportBean;
import net.plang.DYAccount.hr.to.EmployeeBean;

public interface BaseApplicationService {

    EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException;
    
    public ArrayList<SlipIreportBean> getIreportData(String slipNo);

}
