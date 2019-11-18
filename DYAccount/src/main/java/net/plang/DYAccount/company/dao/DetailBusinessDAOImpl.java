package net.plang.DYAccount.company.dao;

import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import net.plang.DYAccount.common.dao.IBatisDAOSupport;
import net.plang.DYAccount.company.to.DetailBusinessBean;

public class DetailBusinessDAOImpl extends IBatisDAOSupport implements DetailBusinessDAO{

	 //업태소분류리스트 조회
    @Override
    public ArrayList<DetailBusinessBean> selectDetailBusinessList(String businessCode) {
       return (ArrayList<DetailBusinessBean>)this.getSqlMapClientTemplate().queryForList("detailBusiness.selectDetailBusinessList", businessCode);
    }

}
