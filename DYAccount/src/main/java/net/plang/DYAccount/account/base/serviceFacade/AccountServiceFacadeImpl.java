package net.plang.DYAccount.account.base.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.account.base.applicationService.AccountApplicationService;
import net.plang.DYAccount.account.base.to.AccountBean;
import net.plang.DYAccount.account.base.to.AccountControlBean;

public class AccountServiceFacadeImpl implements AccountServiceFacade {
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

    public void setAccountApplicationService(AccountApplicationService accountApplicationService) {
        this.accountApplicationService = accountApplicationService;
    }
}
