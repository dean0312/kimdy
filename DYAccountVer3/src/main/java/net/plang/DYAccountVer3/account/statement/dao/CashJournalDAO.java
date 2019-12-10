package net.plang.DYAccountVer3.account.statement.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.account.statement.to.CashJournalBean;
public interface CashJournalDAO {


    public ArrayList<CashJournalBean> selectCashJournalList(String fromDate, String toDate);

}
