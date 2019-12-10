package net.plang.DYAccountVer3.account.statement.serviceFacade;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.account.statement.applicationService.StatementApplicationService;

@Service
public class StatementServiceFacadeImpl implements StatementServiceFacade {
	@Autowired
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

   
}
