package net.plang.DYAccount.account.base.dao;


import net.plang.DYAccount.account.base.to.AccountBean;
import net.plang.DYAccount.account.base.to.AccountControlBean;
import net.plang.DYAccount.common.dao.IBatisDAOSupport;

import java.util.ArrayList;

public class AccountDAOImpl extends IBatisDAOSupport implements AccountDAO {
	public AccountBean selectAccount(String accountCode) {
		return (AccountBean) this.getSqlMapClientTemplate().queryForObject("account.selectAccount", accountCode);
	}

	@Override
	public ArrayList<AccountBean> selectParentAccountList() {
		return (ArrayList<AccountBean>) this.getSqlMapClientTemplate().queryForList("account.selectParentAccountList");
	}

	@Override
	public ArrayList<AccountBean> selectDetailAccountList(String accountCode) {
		return (ArrayList<AccountBean>) this.getSqlMapClientTemplate().queryForList("account.selectDetailAccountList",
				accountCode);
	}

	@Override
	public void updateAccount(AccountBean accountBean) {
		this.getSqlMapClientTemplate().update("account.updateAccount", accountBean);
	}

	@Override
	public ArrayList<AccountBean> selectAccountListByName(String accountName) {
		return (ArrayList<AccountBean>) this.getSqlMapClientTemplate().queryForList("account.selectAccountListByName",
				accountName);
	}

	@Override
	public ArrayList<AccountControlBean> selectAccountControlList(String accountCode) {
		return (ArrayList<AccountControlBean>) this.getSqlMapClientTemplate()
				.queryForList("account.selectAccountControlList", accountCode);
	}
}
