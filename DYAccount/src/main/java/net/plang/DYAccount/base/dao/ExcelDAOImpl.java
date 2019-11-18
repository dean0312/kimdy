package net.plang.DYAccount.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import net.plang.DYAccount.base.to.SlipExcelBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

public class ExcelDAOImpl extends IBatisDAOSupport implements ExcelDAO{
	public List<SlipExcelBean> selectSlipExcelData(String fromDate,String toDate){
		HashMap<String, String> params = new HashMap<>();
        params.put("fromDate", fromDate);
        params.put("toDate", toDate);
        try {
        return (List<SlipExcelBean>) getSqlMapClientTemplate().queryForList("Excel.selectSlipExcelList", params);
        }catch(EmptyResultDataAccessException e) {
        	return null;
        }
	}
}
