package net.plang.DYAccountVer3.base.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.base.dao.ExcelDAO;
import net.plang.DYAccountVer3.base.to.SlipExcelBean;
@Component
@Transactional
public class ExcelApplicationServiceImpl implements ExcelApplicationService{
	@Autowired
	private ExcelDAO excelDAO;
	public List<SlipExcelBean> getSlipExcelData(String fromDate,String toDate){
		return excelDAO.selectSlipExcelData(fromDate, toDate);
	}
	
}
