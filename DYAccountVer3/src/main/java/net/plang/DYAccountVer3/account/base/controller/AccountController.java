package net.plang.DYAccountVer3.account.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.plang.DYAccountVer3.account.base.serviceFacade.AccountServiceFacade;
import net.plang.DYAccountVer3.account.base.to.AccountBean;
import net.plang.DYAccountVer3.account.base.to.AccountControlBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
public class AccountController {
	@Autowired
	private AccountServiceFacade accountServiceFacade;

	@RequestMapping(value = "account/Account", method = RequestMethod.GET)
	public AccountBean getAccount(@RequestParam String accountCode) {
		return accountServiceFacade.getAccount(accountCode);
	}
	@RequestMapping(value="account/Account",method=RequestMethod.PUT)
	public void editAccount(@RequestParam String accountInnerCode,@RequestParam String accountName) {
		AccountBean accountBean = new AccountBean();
		// accountBean.setAccountCharacter(accountCharacter);
		// accountBean.setAccountDescription(accountDescription);
		accountBean.setAccountInnerCode(accountInnerCode);
		accountBean.setAccountName(accountName);

		accountServiceFacade.updateAccount(accountBean);
	}


	@RequestMapping(value = "account/AccountControlList", method = RequestMethod.GET)
	public ArrayList<AccountControlBean> getAccountControlList(@RequestParam String accountCode) {

		return accountServiceFacade.getAccountControlList(accountCode);
	}

	@RequestMapping(value = "account/AccountListByName", method = RequestMethod.GET)
	public ArrayList<AccountBean> getAccountListByName(@RequestParam String accountName) {

		return accountServiceFacade.getAccountListByName(accountName);
	}

	@RequestMapping(value = "account/ParentAccountList", method = RequestMethod.GET)
	public ArrayList<AccountBean> findParentAccountList() {

		return accountServiceFacade.findParentAccountList();

	}

	@RequestMapping(value = "account/DetailAccountList", method = RequestMethod.GET)
	public ArrayList<AccountBean> findDetailAccountList(@RequestParam String code) {

		return accountServiceFacade.findDetailAccountList(code);
	}

	
}
