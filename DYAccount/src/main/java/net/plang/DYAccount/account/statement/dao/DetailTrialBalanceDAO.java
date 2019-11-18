package net.plang.DYAccount.account.statement.dao;

import java.util.ArrayList;

import net.plang.DYAccount.account.statement.to.DetailTrialBalanceBean;

public interface DetailTrialBalanceDAO {


    public ArrayList<DetailTrialBalanceBean> selectDetailTrialBalance(String fromDate, String toDate);

}
