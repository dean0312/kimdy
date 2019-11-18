package net.plang.DYAccount.company.dao;

import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import net.plang.DYAccount.common.dao.IBatisDAOSupport;
import net.plang.DYAccount.company.to.BusinessBean;

public class BusinessDAOImpl extends IBatisDAOSupport implements BusinessDAO {

    //업태리스트 조회
    @Override
    public ArrayList<BusinessBean> selectBusinessList() {
        return (ArrayList<BusinessBean>)this.getSqlMapClientTemplate().queryForList("business.selectBusinessList");
    }

}
