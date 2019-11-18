package net.plang.DYAccount.account.base.applicationService;


import java.util.ArrayList;


import net.plang.DYAccount.account.base.dao.AccountDAO;
import net.plang.DYAccount.account.base.to.AccountBean;
import net.plang.DYAccount.account.base.to.AccountControlBean;

@SuppressWarnings("unused")
public class AccountApplicationServiceImpl implements AccountApplicationService {
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


    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
