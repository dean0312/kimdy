package net.plang.DYAccountVer3.account.base.serviceFacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.plang.DYAccountVer3.account.base.applicationService.AccountApplicationService;
import net.plang.DYAccountVer3.account.base.to.AccountBean;
import net.plang.DYAccountVer3.account.base.to.AccountControlBean;

@Service
public class AccountServiceFacadeImpl implements AccountServiceFacade {
	@Autowired
	private AccountApplicationService accountApplicationService;

	@Override
	public AccountBean getAccount(String accountCode) {
		return accountApplicationService.getAccount(accountCode);
	}

	@Override
	public ArrayList<AccountBean> findParentAccountList() {
		return accountApplicationService.findParentAccountList();
	}

	@Override
	public ArrayList<AccountBean> findDetailAccountList(String code) {
		return accountApplicationService.findDetailAccountList(code);
	}

	@Override
	public void updateAccount(AccountBean accountBean) {
		accountApplicationService.updateAccount(accountBean);
	}

	@Override
	public ArrayList<AccountBean> getAccountListByName(String accountName) {
		return accountApplicationService.getAccountListByName(accountName);
	}

	@Override
	public ArrayList<AccountControlBean> getAccountControlList(String accountCode) {
		return accountApplicationService.getAccountControlList(accountCode);
	}

}
