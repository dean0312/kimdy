package net.plang.DYAccount.base.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.base.dao.ReportDAO;
import net.plang.DYAccount.base.to.SlipIreportBean;
import net.plang.DYAccount.hr.dao.EmployeeDAO;


public class ReportApplicationServiceImpl implements ReportApplicationService {
	private ReportDAO reportDAO;
	
	
	@Override
	public ArrayList<SlipIreportBean> getSlipIreportData(String SlipNo) {
		// TODO Auto-generated method stub
		return reportDAO.selectSlipIreportData(SlipNo);
	}
	  public void setReportDAO(ReportDAO reportDAO) {
	        this.reportDAO = reportDAO;
	    }

}
