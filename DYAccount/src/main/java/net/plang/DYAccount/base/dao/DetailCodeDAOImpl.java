package net.plang.DYAccount.base.dao;


import net.plang.DYAccount.base.to.DetailCodeBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;


import java.util.ArrayList;
import java.util.HashMap;

public class DetailCodeDAOImpl extends IBatisDAOSupport implements DetailCodeDAO {

    @Override
    public ArrayList<DetailCodeBean> selectDetailCodeList(HashMap<String, String> param) { 	
    	return (ArrayList<DetailCodeBean>) this.getSqlMapClientTemplate().queryForList("codeDetail.selectDetailCodeList", param);
    }

    @Override
    public void insertDetailCode(DetailCodeBean codeDetailBean) {
    	this.getSqlMapClientTemplate().insert("codeDetail.insertDetailCode", codeDetailBean);
    }

    @Override
    public void updateDetailCode(DetailCodeBean codeDetailBean) {
    	this.getSqlMapClientTemplate().update("codeDetail.updateDetailCode", codeDetailBean);
    }

    @Override
    public void deleteDetailCode(String codeNo) {
    	this.getSqlMapClientTemplate().delete("codeDetail.deleteDetailCode", codeNo);
    }
}
