package net.plang.DYAccount.base.dao;

import java.util.List;

import net.plang.DYAccount.base.to.SlipExcelBean;


public interface ExcelDAO {
	List<SlipExcelBean> selectSlipExcelData(String fromDate,String toDate);
}
