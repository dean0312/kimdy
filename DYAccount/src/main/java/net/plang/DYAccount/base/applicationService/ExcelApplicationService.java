package net.plang.DYAccount.base.applicationService;

import java.util.List;

import net.plang.DYAccount.base.to.SlipExcelBean;

public interface ExcelApplicationService {
	/*전표 엑셀*/
	public List<SlipExcelBean> getSlipExcelData(String fromDate,String toDate);
}
