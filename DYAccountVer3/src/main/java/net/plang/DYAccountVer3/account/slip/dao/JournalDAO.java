package net.plang.DYAccountVer3.account.slip.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.account.slip.to.JournalBean;
@Mapper
public interface JournalDAO {
	public String selectJournalName(String slipNo);

    public ArrayList<JournalBean> selectRangedJournalList(String fromDate, String toDate);

    public ArrayList<JournalBean> selectJournalList(String slipNo);

    public JournalBean selectJournal(String journalNo);

    public void insertJournal(JournalBean journalBean);

    public void deleteJournal(JournalBean journalBean);

    public void updateJournal(JournalBean journalBean);
}
