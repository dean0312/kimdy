package net.plang.DYAccount.account.base.serviceFacade;

import java.util.ArrayList;

import net.plang.DYAccount.account.base.to.AccountBean;
import net.plang.DYAccount.account.base.to.AccountControlBean;

public interface AccountServiceFacade {

    public AccountBean getAccount(String code);

    public ArrayList<AccountBean> findParentAccountList();

    public ArrayList<AccountBean> findDetailAccountList(String code);

    public void updateAccount(AccountBean accountBean);

    ArrayList<AccountBean> getAccountListByName(String accountName);

    ArrayList<AccountControlBean> getAccountControlList(String accountCode);
}
