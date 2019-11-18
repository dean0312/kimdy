package net.plang.DYAccount.account.statement.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.plang.DYAccount.account.statement.serviceFacade.StatementServiceFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class FinancialPositionController extends AbstractController {
    private StatementServiceFacade statementServiceFacade;

    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("jsonView");

        String toDate = request.getParameter("toDate");

        HashMap<String, Object> financialPosition = statementServiceFacade.getFinancialPosition(toDate);
        modelAndView.addObject("financialPosition", financialPosition);

        String errorCode = financialPosition.get("errorCode").toString();
        String errorMsg = financialPosition.get("errorMsg").toString();

        modelAndView.addObject("financialPosition", financialPosition.get("financialPosition"));
        modelAndView.addObject("errorCode", errorCode);
        modelAndView.addObject("errorMsg", errorMsg);

        return modelAndView;
    }

    public void setStatementServiceFacade(StatementServiceFacade statementServiceFacade) {
        this.statementServiceFacade = statementServiceFacade;
    }
}

