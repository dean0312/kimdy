package net.plang.DYAccount.account.statement.serviceFacade;

import java.util.HashMap;

import net.plang.DYAccount.account.statement.applicationService.StatementApplicationService;


public class StatementServiceFacadeImpl implements StatementServiceFacade {
    private StatementApplicationService statementApplicationService;

    @Override
    public HashMap<String, Object> getTotalTrialBalance(String toDate) {
        return statementApplicationService.getTotalTrialBalance(toDate);
    }

    @Override
    public HashMap<String, Object> getIncomeStatement(String toDate) {
        return statementApplicationService.getIncomeStatement(toDate);
    }

    @Override
    public HashMap<String, Object> getFinancialPosition(String toDate) {
        return statementApplicationService.getFinancialPosition(toDate);
    }

    public void setStatementApplicationService(StatementApplicationService statementApplicationService) {
        this.statementApplicationService = statementApplicationService;
    }
}
