package net.plang.DYAccountVer3.account.statement.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.account.statement.to.DetailTrialBalanceBean;
public interface DetailTrialBalanceDAO {


    public ArrayList<DetailTrialBalanceBean> selectDetailTrialBalance(String fromDate, String toDate);

}
