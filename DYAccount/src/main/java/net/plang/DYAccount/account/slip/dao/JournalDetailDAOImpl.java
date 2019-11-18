package net.plang.DYAccount.account.slip.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import net.plang.DYAccount.account.slip.to.JournalDetailBean;
import net.plang.DYAccount.account.slip.to.SlipBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

import java.util.ArrayList;

public class JournalDetailDAOImpl extends IBatisDAOSupport implements JournalDetailDAO {


    @Override
    public ArrayList<JournalDetailBean> selectJournalDetailList(String journalNo) {
    	return (ArrayList<JournalDetailBean>) this.getSqlMapClientTemplate().queryForList("journalDetail.selectJournalDetailList", journalNo);
    }

    @Override
    public void deleteJournalDetailByJournalNo(String journalNo) {
    	this.getSqlMapClientTemplate().delete("journalDetail.deleteJournalDetailByJournalNo",journalNo);
    }

    @Override
    public void updateJournalDetail(JournalDetailBean journalDetailBean) {
    	this.getSqlMapClientTemplate().update("journalDetail.updateJournalDetail",journalDetailBean);
    }

    @Override
    public void insertJournalDetailList(String journalNo) {
    	this.getSqlMapClientTemplate().insert("journalDetail.insertJournalDetailList",journalNo);
    }
}
