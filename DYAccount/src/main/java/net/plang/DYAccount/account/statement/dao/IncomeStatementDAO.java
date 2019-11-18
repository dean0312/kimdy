package net.plang.DYAccount.account.statement.dao;

import java.util.HashMap;

public interface IncomeStatementDAO {
    public HashMap<String, Object> callIncomeStatement(String toDate);
}
