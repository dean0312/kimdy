package net.plang.DYAccount.base.applicationService;

import java.util.List;

import net.plang.DYAccount.account.slip.to.SlipBean;
import net.plang.DYAccount.base.dao.ExcelDAO;
import net.plang.DYAccount.base.to.SlipExcelBean;

public class ExcelApplicationServiceImpl implements ExcelApplicationService{
	private ExcelDAO excelDAO;
	public List<SlipExcelBean> getSlipExcelData(String fromDate,String toDate){
		return excelDAO.selectSlipExcelData(fromDate, toDate);
	}
	 public void setExcelDAO(ExcelDAO excelDAO) {
	        this.excelDAO = excelDAO;
	    }
}
