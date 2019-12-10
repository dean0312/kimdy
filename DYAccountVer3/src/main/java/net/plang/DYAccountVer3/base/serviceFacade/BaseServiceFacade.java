package net.plang.DYAccountVer3.base.serviceFacade;

import java.util.ArrayList;
import java.util.List;

import net.plang.DYAccountVer3.base.exception.DeptCodeNotFoundException;
import net.plang.DYAccountVer3.base.exception.IdNotFoundException;
import net.plang.DYAccountVer3.base.exception.PwMissmatchException;
import net.plang.DYAccountVer3.base.to.SlipExcelBean;
import net.plang.DYAccountVer3.base.to.SlipIreportBean;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

public interface BaseServiceFacade {
    EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException, DeptCodeNotFoundException;

    public ArrayList<SlipIreportBean> getSlipIreportData(String slipNo);
    public List<SlipExcelBean> getSlipExcelData(String fromDate, String toDate);
}
