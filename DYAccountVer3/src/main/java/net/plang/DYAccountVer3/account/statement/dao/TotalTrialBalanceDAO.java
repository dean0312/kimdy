package net.plang.DYAccountVer3.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface TotalTrialBalanceDAO {


    public HashMap<String, Object> callTotalTrialBalance(HashMap<String,Object> totalTrialBalanceParams);

}
