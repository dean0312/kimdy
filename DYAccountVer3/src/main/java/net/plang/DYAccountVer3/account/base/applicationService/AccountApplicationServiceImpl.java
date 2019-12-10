package net.plang.DYAccountVer3.account.base.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.account.base.dao.AccountDAO;
import net.plang.DYAccountVer3.account.base.to.AccountBean;
import net.plang.DYAccountVer3.account.base.to.AccountControlBean;

@SuppressWarnings("unused")
@Component
@Transactional
public class AccountApplicationServiceImpl implements AccountApplicationService {
	@Autowired
	private AccountDAO accountDAO;

	public AccountBean getAccount(String accountCode) {
		System.out.println("ggggggggggggg");
		return accountDAO.selectAccount(accountCode);
	}

	@Override
	public ArrayList<AccountBean> findParentAccountList() {
		return accountDAO.selectParentAccountList();
	}

	public ArrayList<AccountBean> findDetailAccountList(String code) {
		return accountDAO.selectDetailAccountList(code);
	}

	@Override
	public void updateAccount(AccountBean accountBean) {
		accountDAO.updateAccount(accountBean);
	}

	@Override
	public ArrayList<AccountBean> getAccountListByName(String accountName) {
		return accountDAO.selectAccountListByName(accountName);
	}

	@Override
	public ArrayList<AccountControlBean> getAccountControlList(String accountCode) {
		return accountDAO.selectAccountControlList(accountCode);
	}

}
