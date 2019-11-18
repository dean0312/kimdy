package net.plang.DYAccount.base.dao;


import net.plang.DYAccount.base.to.CodeBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;


import java.util.ArrayList;


public class CodeDAOImpl extends IBatisDAOSupport implements CodeDAO {

    @Override
    public ArrayList<CodeBean> selectCodeList() {
    	return (ArrayList<CodeBean>) this.getSqlMapClientTemplate().queryForObject("code.selectCodeList");
    }

    @Override
    public void insertCode(CodeBean codeBean) {
    	this.getSqlMapClientTemplate().insert("code.insertCode", codeBean);
    }

    @Override
    public void updateCode(CodeBean codeBean) {
    	this.getSqlMapClientTemplate().update("code.updateCode", codeBean);
    }

    @Override
    public void deleteCode(String divisionCodeNo) {
    	this.getSqlMapClientTemplate().delete("code.deleteCode", divisionCodeNo);
    }

}
