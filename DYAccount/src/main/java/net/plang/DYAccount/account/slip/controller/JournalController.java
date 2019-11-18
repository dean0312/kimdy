package net.plang.DYAccount.account.slip.controller;

import net.plang.DYAccount.account.slip.serviceFacade.JournalServiceFacade;
import net.plang.DYAccount.account.slip.to.JournalBean;
import net.plang.DYAccount.common.util.BeanCreator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class JournalController extends MultiActionController{
    private JournalServiceFacade journalServiceFacade;

    public ModelAndView findRangedJournalList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        String fromDate = request.getParameter("from");
        String toDate = request.getParameter("to");

        ArrayList<JournalBean> journalList = journalServiceFacade.findRangedJournalList(fromDate, toDate);
        modelAndView.addObject("journalList", journalList);

        return modelAndView;
    }

    public ModelAndView findSingleJournalList(HttpServletRequest request, HttpServletResponse response) {
        String slipNo = request.getParameter("slipNo");
        ModelAndView modelAndView = new ModelAndView("jsonView");

        modelAndView.addObject("journalList", journalServiceFacade.findSingleJournalList(slipNo));
        return modelAndView;
    }


    public ModelAndView editJournal(HttpServletRequest request, HttpServletResponse response) {
        String slipNo = request.getParameter("slipNo");
        JSONArray journalObjs = JSONArray.fromObject(request.getParameter("journalObj"));

        ModelAndView modelAndView = new ModelAndView("jsonView");
        ArrayList<JournalBean> journalBeanList = new ArrayList<>();

        for (Object journalObj : journalObjs) {
            JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObj), JournalBean.class);
            journalBean.setSlipNo(slipNo);

            journalBeanList.add(journalBean);
        }

        journalServiceFacade.editJournal(slipNo, journalBeanList);

        modelAndView.addObject("slipNo", slipNo);
        return modelAndView;
    }

    public void setJournalServiceFacade(JournalServiceFacade journalServiceFacade) {
        this.journalServiceFacade = journalServiceFacade;
    }
}
