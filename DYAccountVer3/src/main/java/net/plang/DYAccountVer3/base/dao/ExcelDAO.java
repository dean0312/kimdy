package net.plang.DYAccountVer3.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.base.to.SlipExcelBean;

@Mapper
public interface ExcelDAO {
	List<SlipExcelBean> selectSlipExcelData(String fromDate,String toDate);
}
