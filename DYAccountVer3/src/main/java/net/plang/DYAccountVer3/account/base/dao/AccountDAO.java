package net.plang.DYAccountVer3.account.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.plang.DYAccountVer3.account.base.to.AccountBean;
import net.plang.DYAccountVer3.account.base.to.AccountControlBean;
@Mapper
public interface AccountDAO {

    public AccountBean selectAccount(String accountCode);

    public ArrayList<AccountBean> selectDetailAccountList(String code);

    public ArrayList<AccountBean> selectParentAccountList();

    public void updateAccount(AccountBean accountBean);

    ArrayList<AccountBean> selectAccountListByName(String accountName);

    ArrayList<AccountControlBean> selectAccountControlList(String accountCode);
}
