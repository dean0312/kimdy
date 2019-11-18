package net.plang.DYAccount.base.dao;

import java.util.ArrayList;

import net.plang.DYAccount.base.to.SlipIreportBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

public class ReportDAOImpl extends IBatisDAOSupport implements ReportDAO {

	@Override
	public ArrayList<SlipIreportBean> selectSlipIreportData(String SlipNo) {
		return (ArrayList<SlipIreportBean>) this.getSqlMapClientTemplate().queryForList("iReport.selectSlipIreportData", SlipNo);
	}
}
