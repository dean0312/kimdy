package net.plang.DYAccount.account.statement.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.plang.DYAccount.account.statement.serviceFacade.StatementServiceFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class TotalTrialBalanceController extends AbstractController {

    private StatementServiceFacade statementServiceFacade;

    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("jsonView");

        String toDate = request.getParameter("toDate");
        

        HashMap<String, Object> totalTrialBalanceMap = statementServiceFacade.getTotalTrialBalance(toDate);
        modelAndView.addObject("totalTrialBalance", totalTrialBalanceMap);

        String errorCode = totalTrialBalanceMap.get("errorCode").toString();
        String errorMsg = totalTrialBalanceMap.get("errorMsg").toString();

        modelAndView.addObject("totalTrialBalance", totalTrialBalanceMap.get("totalTrialBalance"));
        modelAndView.addObject("errorCode", errorCode);
        modelAndView.addObject("errorMsg", errorMsg);

        return modelAndView;
    }

    public void setStatementServiceFacade(StatementServiceFacade statementServiceFacade) {
        this.statementServiceFacade = statementServiceFacade;
    }
}
