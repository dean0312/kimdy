package net.plang.DYAccountVer3.account.statement.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface IncomeStatementDAO {
    public HashMap<String, Object> callIncomeStatement(String toDate);
}
