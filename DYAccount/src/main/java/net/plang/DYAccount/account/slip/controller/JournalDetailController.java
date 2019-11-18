package net.plang.DYAccount.account.slip.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.account.slip.serviceFacade.JournalDetailServiceFacade;
import net.plang.DYAccount.account.slip.serviceFacade.JournalDetailServiceFacadeImpl;
import net.plang.DYAccount.account.slip.to.JournalDetailBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JournalDetailController extends MultiActionController {
    private JournalDetailServiceFacade journalDetailServiceFacade;

    public ModelAndView getJournalDetailList(HttpServletRequest request, HttpServletResponse response) {
        String journalNo = request.getParameter("journalNo");
        ModelAndView modelAndView = new ModelAndView("jsonView");

        modelAndView.addObject("journalDetailList", journalDetailServiceFacade.getJournalDetailList(journalNo));
        return modelAndView;
    }

    public ModelAndView editJournalDetail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        JournalDetailBean journalDetailBean = new JournalDetailBean();
        journalDetailBean.setJournalDetailNo(request.getParameter("journalDetailNo"));
        journalDetailBean.setJournalDescription(request.getParameter("journalDescription"));

        journalDetailServiceFacade.editJournalDetail(journalDetailBean);
        return modelAndView;
    }

    public void setJournalDetailServiceFacade(JournalDetailServiceFacade journalDetailServiceFacade) {
        this.journalDetailServiceFacade = journalDetailServiceFacade;
    }
}
