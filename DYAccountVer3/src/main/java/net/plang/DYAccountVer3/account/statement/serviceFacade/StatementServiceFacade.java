package net.plang.DYAccountVer3.account.statement.serviceFacade;

import java.util.HashMap;

public interface StatementServiceFacade {
    HashMap<String, Object> getTotalTrialBalance(String toDate);

    HashMap<String, Object> getFinancialPosition(String toDate);

    HashMap<String, Object> getIncomeStatement(String toDate);
}

