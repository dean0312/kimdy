package net.plang.DYAccount.account.statement.applicationService;

import java.util.HashMap;

import net.plang.DYAccount.account.statement.dao.FinancialPositionDAO;
import net.plang.DYAccount.account.statement.dao.IncomeStatementDAO;
import net.plang.DYAccount.account.statement.dao.TotalTrialBalanceDAO;

public class StatementApplicationServiceImpl implements StatementApplicationService {
    private TotalTrialBalanceDAO totalTrialBalanceDAO;
    private FinancialPositionDAO financialPositionDAO;
    private IncomeStatementDAO incomeStatementDAO;

    public void setFinancialPositionDAO(FinancialPositionDAO financialPositionDAO) {
        this.financialPositionDAO = financialPositionDAO;
    }

    public void setTotalTrialBalanceDAO(TotalTrialBalanceDAO totalTrialBalanceDAO) {
        this.totalTrialBalanceDAO = totalTrialBalanceDAO;
    }

    public void setIncomeStatementDAO(IncomeStatementDAO incomeStatementDAO) {
        this.incomeStatementDAO = incomeStatementDAO;
    }

    @Override
    public HashMap<String, Object> getTotalTrialBalance(String toDate) {
        return totalTrialBalanceDAO.callTotalTrialBalance(toDate);
    }

    @Override
    public HashMap<String, Object> getIncomeStatement(String toDate) {
        return incomeStatementDAO.callIncomeStatement(toDate);
    }

    @Override
    public HashMap<String, Object> getFinancialPosition(String toDate) {
        return financialPositionDAO.callFinancialPosition(toDate);
    }
}
