package net.plang.DYAccountVer3.base.serviceFacade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.base.applicationService.BaseApplicationService;
import net.plang.DYAccountVer3.base.applicationService.ExcelApplicationService;
import net.plang.DYAccountVer3.base.applicationService.ReportApplicationService;
import net.plang.DYAccountVer3.base.exception.IdNotFoundException;
import net.plang.DYAccountVer3.base.exception.PwMissmatchException;
import net.plang.DYAccountVer3.base.to.SlipExcelBean;
import net.plang.DYAccountVer3.base.to.SlipIreportBean;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

@Service
public class BaseServiceFacadeImpl implements BaseServiceFacade {
	@Autowired
    private BaseApplicationService baseApplicationService;
	@Autowired
    private ReportApplicationService reportApplicationService;
	@Autowired
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
   
}
