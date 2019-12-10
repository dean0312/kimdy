package net.plang.DYAccountVer3.account.slip.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.account.slip.to.JournalDetailBean;
@Mapper
public interface JournalDetailDAO {

    ArrayList<JournalDetailBean> selectJournalDetailList(String journalNo);

//	public JournalDetailBean selectJournalDetail(String journalDetailNo);

    void deleteJournalDetailByJournalNo(String journalNo);

    void updateJournalDetail(JournalDetailBean journalDetailBean);

    void insertJournalDetailList(String journalNo);

}
