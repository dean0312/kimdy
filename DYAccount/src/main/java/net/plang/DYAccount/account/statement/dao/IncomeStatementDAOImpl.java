package net.plang.DYAccount.account.statement.dao;


import net.plang.DYAccount.account.statement.to.FinancialPositionBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

import java.util.ArrayList;
import java.util.HashMap;

public class IncomeStatementDAOImpl extends IBatisDAOSupport implements IncomeStatementDAO {

    @Override
    public HashMap<String, Object> callIncomeStatement(String toDate) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("toDate", toDate);

        ArrayList<FinancialPositionBean> incomeStatement = (ArrayList<FinancialPositionBean>) getSqlMapClientTemplate()
                .queryForList("incomeStatement.callIncomeStatement", params);

        HashMap<String, Object> result = new HashMap<>();
        result.put("incomeStatement", incomeStatement);
        result.put("errorCode", params.get("ERROR_CODE"));
        result.put("errorMsg", params.get("ERROR_MSG"));

        return result;
    }

}
