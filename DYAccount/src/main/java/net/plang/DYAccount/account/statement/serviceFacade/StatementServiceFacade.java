package net.plang.DYAccount.account.statement.serviceFacade;

import java.util.HashMap;

public interface StatementServiceFacade {
    HashMap<String, Object> getTotalTrialBalance(String toDate);

    HashMap<String, Object> getFinancialPosition(String toDate);

    HashMap<String, Object> getIncomeStatement(String toDate);
}

