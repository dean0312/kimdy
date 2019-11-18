package net.plang.DYAccount.account.statement.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.plang.DYAccount.account.statement.serviceFacade.StatementServiceFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


public class IncomeStatementController extends AbstractController {
    private StatementServiceFacade statementServiceFacade;

    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        String toDate = request.getParameter("toDate");

        HashMap<String, Object> incomeStatementMap = statementServiceFacade.getIncomeStatement(toDate);
        modelAndView.addObject("incomeStatement", incomeStatementMap);

        String errorCode = incomeStatementMap.get("errorCode").toString();
        String errorMsg = incomeStatementMap.get("errorMsg").toString();

        modelAndView.addObject("incomeStatement", incomeStatementMap.get("incomeStatement"));
        modelAndView.addObject("errorCode", errorCode);
        modelAndView.addObject("errorMsg", errorMsg);

        return modelAndView;
    }

    public void setStatementServiceFacade(StatementServiceFacade statementServiceFacade) {
        this.statementServiceFacade = statementServiceFacade;
    }
}

