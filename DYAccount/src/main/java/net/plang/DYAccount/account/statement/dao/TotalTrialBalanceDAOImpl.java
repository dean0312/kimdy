package net.plang.DYAccount.account.statement.dao;



import net.plang.DYAccount.account.statement.to.FinancialPositionBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

import java.util.ArrayList;
import java.util.HashMap;

public class TotalTrialBalanceDAOImpl extends IBatisDAOSupport implements TotalTrialBalanceDAO {

    @Override
    public HashMap<String, Object> callTotalTrialBalance(String toDate) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("toDate", toDate);

        ArrayList<FinancialPositionBean> totalTrialBalance = (ArrayList<FinancialPositionBean>) getSqlMapClientTemplate()
                .queryForList("totalTrialBalance.callTotalTrialBalance", params);

        HashMap<String, Object> result = new HashMap<>();
        result.put("totalTrialBalance", totalTrialBalance);
        result.put("errorCode", params.get("ERROR_CODE"));
        result.put("errorMsg", params.get("ERROR_MSG"));

        return result;
    }
}
