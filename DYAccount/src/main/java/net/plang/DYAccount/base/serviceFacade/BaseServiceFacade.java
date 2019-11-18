package net.plang.DYAccount.base.serviceFacade;

import java.util.ArrayList;
import java.util.List;

import net.plang.DYAccount.base.exception.DeptCodeNotFoundException;
import net.plang.DYAccount.base.exception.IdNotFoundException;
import net.plang.DYAccount.base.exception.PwMissmatchException;
import net.plang.DYAccount.base.to.SlipExcelBean;
import net.plang.DYAccount.base.to.SlipIreportBean;
import net.plang.DYAccount.hr.to.EmployeeBean;

public interface BaseServiceFacade {
    EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException, DeptCodeNotFoundException;

    public ArrayList<SlipIreportBean> getSlipIreportData(String slipNo);
    public List<SlipExcelBean> getSlipExcelData(String fromDate, String toDate);
}
