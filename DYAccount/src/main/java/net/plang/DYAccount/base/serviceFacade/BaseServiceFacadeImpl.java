package net.plang.DYAccount.base.serviceFacade;

import java.util.ArrayList;
import java.util.List;

import net.plang.DYAccount.base.applicationService.BaseApplicationService;
import net.plang.DYAccount.base.applicationService.ExcelApplicationService;
import net.plang.DYAccount.base.applicationService.ReportApplicationService;
import net.plang.DYAccount.base.exception.IdNotFoundException;
import net.plang.DYAccount.base.exception.PwMissmatchException;
import net.plang.DYAccount.base.to.SlipExcelBean;
import net.plang.DYAccount.base.to.SlipIreportBean;
import net.plang.DYAccount.hr.to.EmployeeBean;


public class BaseServiceFacadeImpl implements BaseServiceFacade {
    private BaseApplicationService baseApplicationService;
    private ReportApplicationService reportApplicationService;
    private ExcelApplicationService excelApplicationService;

    @Override
    public EmployeeBean getLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException {
        return baseApplicationService.getLoginData(empCode, userPw);
    }
    
    @Override
    public ArrayList<SlipIreportBean> getSlipIreportData(String slipNo){
    	return reportApplicationService.getSlipIreportData(slipNo);
    }
    @Override
    public List<SlipExcelBean> getSlipExcelData(String from, String to){
    	return excelApplicationService.getSlipExcelData(from,to);
    }
    public void setBaseApplicationService(BaseApplicationService baseApplicationService) {
        this.baseApplicationService = baseApplicationService;
    }
    public void setReportApplicationService(ReportApplicationService reportApplicationService) {
        this.reportApplicationService = reportApplicationService;
    }
    public void setExcelApplicationService(ExcelApplicationService excelApplicationService) {
    	this.excelApplicationService=excelApplicationService;
    }
}
