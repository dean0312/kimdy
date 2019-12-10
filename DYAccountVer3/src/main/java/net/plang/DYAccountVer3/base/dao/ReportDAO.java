package net.plang.DYAccountVer3.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.base.to.SlipIreportBean;

@Mapper
public interface ReportDAO {
	ArrayList<SlipIreportBean> selectSlipIreportData(String SlipNo);

	
}
