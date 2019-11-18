package net.plang.DYAccount.account.statement.dao;

import net.plang.DYAccount.account.statement.to.FinancialPositionBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

import java.util.ArrayList;
import java.util.HashMap;

public class FinancialPositionDAOImpl extends IBatisDAOSupport implements FinancialPositionDAO {
    @Override
    public HashMap<String, Object> callFinancialPosition(String toDate) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("toDate", toDate);

        ArrayList<FinancialPositionBean> financialPosition = (ArrayList<FinancialPositionBean>) getSqlMapClientTemplate()
                .queryForList("financialPosition.callFinancialPosition", params);

        HashMap<String, Object> result = new HashMap<>();
        result.put("financialPosition", financialPosition);
        result.put("errorCode", params.get("ERROR_CODE"));
        result.put("errorMsg", params.get("ERROR_MSG"));

        return result;
    }
}
