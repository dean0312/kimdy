package net.plang.DYAccountVer3.account.statement.applicationService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.account.statement.dao.FinancialPositionDAO;
import net.plang.DYAccountVer3.account.statement.dao.IncomeStatementDAO;
import net.plang.DYAccountVer3.account.statement.dao.TotalTrialBalanceDAO;

@Component
@Transactional
public class StatementApplicationServiceImpl implements StatementApplicationService {
	@Autowired
	private TotalTrialBalanceDAO totalTrialBalanceDAO;
	@Autowired
	private FinancialPositionDAO financialPositionDAO;
	@Autowired
	private IncomeStatementDAO incomeStatementDAO;

	@Override
	public HashMap<String, Object> getTotalTrialBalance(String toDate) {
		HashMap<String,Object> map=new HashMap<>();
		HashMap<String,Object> map2=new HashMap<>();
		map.put("toDate", toDate);
		//map에는 out 객체들이 담긴다
		map2=totalTrialBalanceDAO.callTotalTrialBalance(map);
		//map2 에는 뭐가담기는것 ?
		return map;
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
