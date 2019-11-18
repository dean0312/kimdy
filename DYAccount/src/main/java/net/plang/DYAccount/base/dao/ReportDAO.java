package net.plang.DYAccount.base.dao;

import java.util.ArrayList;

import net.plang.DYAccount.base.to.SlipIreportBean;


public interface ReportDAO {
	ArrayList<SlipIreportBean> selectSlipIreportData(String SlipNo);

	
}
