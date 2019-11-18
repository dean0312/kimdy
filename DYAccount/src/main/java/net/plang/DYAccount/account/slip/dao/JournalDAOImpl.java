package net.plang.DYAccount.account.slip.dao;


import net.plang.DYAccount.account.slip.to.JournalBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JournalDAOImpl extends IBatisDAOSupport implements JournalDAO {

    @Override
    public JournalBean selectJournal(String journalNo) {
        return null;
    }
    
    @Override
    public ArrayList<JournalBean> selectRangedJournalList(String fromDate, String toDate) {
    	HashMap<String, String> params = new HashMap<>();
        params.put("fromDate", fromDate);
        params.put("toDate", toDate);
        return (ArrayList<JournalBean>) this.getSqlMapClientTemplate().queryForList("journal.selectRangedJournalList", params);
    }

	@Override
    public ArrayList<JournalBean> selectJournalList(String slipNo) {
		return (ArrayList<JournalBean>) this.getSqlMapClientTemplate().queryForList("journal.selectJournalList", slipNo);
    }

    @Override
    public String insertJournal(String slipNo, JournalBean journalBean) {
    	String journalNo = (String ) this.getSqlMapClientTemplate().queryForObject("journal.selectJournalName",slipNo);
    	 journalBean.setSlipNo(slipNo);
         journalBean.setJournalNo(journalNo);
         this.getSqlMapClientTemplate().insert("journal.insertJournal" , journalBean);
        return journalNo;
    }

    @Override
    public void deleteJournal(JournalBean journalBean) {
    	this.getSqlMapClientTemplate().delete("journal.deleteJournal" , journalBean);
    }

    @Override
    public void updateJournal(JournalBean journalBean) {
    	this.getSqlMapClientTemplate().update("journal.deleteJournal" , journalBean);
    }
}
