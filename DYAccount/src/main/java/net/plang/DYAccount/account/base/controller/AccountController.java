package net.plang.DYAccount.account.base.controller;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.account.base.serviceFacade.AccountServiceFacade;
import net.plang.DYAccount.account.base.to.AccountBean;
import net.plang.DYAccount.account.base.to.AccountControlBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AccountController extends MultiActionController {
	
    private AccountServiceFacade accountServiceFacade;
    public ModelAndView getAccount(HttpServletRequest request, HttpServletResponse response) {
    	
    	
        ModelAndView modelAndView = new ModelAndView("jsonView");
        String accountCode = request.getParameter("accountCode");

        AccountBean accountBean = accountServiceFacade.getAccount(accountCode);
        modelAndView.addObject("account", accountBean);
        return modelAndView;
    }

    public ModelAndView getAccountControlList(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("jsonView");
        String accountCode = request.getParameter("accountCode");

        ArrayList<AccountControlBean> accountControlList = accountServiceFacade.getAccountControlList(accountCode);
        modelAndView.addObject("accountControl", accountControlList);
        return modelAndView;
    }

    public ModelAndView getAccountListByName(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("jsonView");
        String accountName = request.getParameter("accountName");

        ArrayList<AccountBean> accountList = accountServiceFacade.getAccountListByName(accountName);
        modelAndView.addObject("accountList", accountList);

        return modelAndView;
    }
    
    public ModelAndView findParentAccountList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        ArrayList<AccountBean> accountList = accountServiceFacade.findParentAccountList();

        modelAndView.addObject("accountList", accountList);
        return modelAndView;
    }

    public ModelAndView findDetailAccountList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");
        String code = request.getParameter("code");

        ArrayList<AccountBean> accountList = accountServiceFacade.findDetailAccountList(code);
        modelAndView.addObject("detailAccountList", accountList);

        return modelAndView;
    }

    public ModelAndView editAccount(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");
        String accountInnerCode = request.getParameter("accountInnerCode");
        String accountName = request.getParameter("accountName");
//            String accountCharacter = request.getParameter("accountCharacter");
//            String accountDescription = request.getParameter("accountDescription");

        AccountBean accountBean = new AccountBean();
//            accountBean.setAccountCharacter(accountCharacter);
//            accountBean.setAccountDescription(accountDescription);
        accountBean.setAccountInnerCode(accountInnerCode);
        accountBean.setAccountName(accountName);

        accountServiceFacade.updateAccount(accountBean);
        return modelAndView;
    }

    public void setAccountServiceFacade(AccountServiceFacade accountServiceFacade) {
        this.accountServiceFacade = accountServiceFacade;
    }
}
