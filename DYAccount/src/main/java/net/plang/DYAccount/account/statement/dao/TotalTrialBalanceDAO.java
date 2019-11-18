package net.plang.DYAccount.account.statement.dao;

import java.util.HashMap;

public interface TotalTrialBalanceDAO {


    public HashMap<String, Object> callTotalTrialBalance(String toDate);

}
