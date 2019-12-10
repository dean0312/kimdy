package net.plang.DYAccountVer3.base.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.base.dao.ReportDAO;
import net.plang.DYAccountVer3.base.to.SlipIreportBean;
import net.plang.DYAccountVer3.hr.dao.EmployeeDAO;

@Component
@Transactional
public class ReportApplicationServiceImpl implements ReportApplicationService {
	@Autowired
	private ReportDAO reportDAO;
	
	
	@Override
	public ArrayList<SlipIreportBean> getSlipIreportData(String SlipNo) {
		// TODO Auto-generated method stub
		return reportDAO.selectSlipIreportData(SlipNo);
	}
	

}
