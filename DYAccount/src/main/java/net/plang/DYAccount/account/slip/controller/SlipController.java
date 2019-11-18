package net.plang.DYAccount.account.slip.controller;

import net.plang.DYAccount.account.slip.serviceFacade.SlipServiceFacade;
import net.plang.DYAccount.account.slip.serviceFacade.SlipServiceFacadeImpl;
import net.plang.DYAccount.account.slip.to.JournalBean;
import net.plang.DYAccount.account.slip.to.SlipBean;
import net.plang.DYAccount.common.util.BeanCreator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;

public class SlipController extends MultiActionController {
    private SlipServiceFacade slipServiceFacade;

    public ModelAndView updateSlip(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");
        SlipBean slipBean = new SlipBean();

        slipBean.setSlipNo(request.getParameter("slipNo"));
        slipBean.setSlipType(request.getParameter("slipType"));
        slipBean.setExpenseReport(request.getParameter("expenseReport"));

        slipServiceFacade.updateSlip(slipBean);

        return modelAndView;
    }

    public ModelAndView addSlip(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        JSONObject slipObj = JSONObject.fromObject(request.getParameter("slipObj"));
        JSONArray journalObjs = JSONArray.fromObject(request.getParameter("journalObj"));
        
        SlipBean slipBean = BeanCreator.getInstance().create(slipObj, SlipBean.class);
        slipBean.setReportingEmpCode(request.getSession().getAttribute("empCode").toString());
        slipBean.setDeptCode(request.getSession().getAttribute("deptCode").toString());

        ArrayList<JournalBean> journalBeans = new ArrayList<>();

        for (Object journalObj : journalObjs) {
            JournalBean journalBean = BeanCreator.getInstance().create(JSONObject.fromObject(journalObj), JournalBean.class);
            journalBean.setSlipNo(slipBean.getSlipNo());
            journalBeans.add(journalBean);
        }
        String slipNo = slipServiceFacade.addSlip(slipBean, journalBeans);

        modelAndView.addObject("slipNo", slipNo);
        return modelAndView;
    }

    public ModelAndView deleteSlip(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");
        String slipNo = request.getParameter("slipNo");

        slipServiceFacade.deleteSlip(slipNo);

        modelAndView.addObject("slipNo", slipNo);
        return modelAndView;
    }


    public ModelAndView approveSlip(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        JSONArray approveSlipList = JSONArray.fromObject(request.getParameter("approveSlipList"));
        String slipStatus = request.getParameter("isApprove");
        ArrayList<SlipBean> slipBeans = new ArrayList<>();

        for (Object approveSlip : approveSlipList) {
            Calendar calendar = Calendar.getInstance();
            String year = calendar.get(Calendar.YEAR) + "";
            String month = "0" + (calendar.get(Calendar.MONTH) + 1);
            String date = "0" + calendar.get(Calendar.DATE);
            String today = year + "-" + month.substring(month.length() - 2) + "-" + date.substring(date.length() - 2);

            SlipBean slipBean = new SlipBean();
            slipBean.setSlipNo(approveSlip.toString());
            slipBean.setApprovalDate(today);
            slipBean.setSlipStatus(slipStatus);
            slipBeans.add(slipBean);
        }

        slipServiceFacade.approveSlip(slipBeans);
        return modelAndView;
    }

    public ModelAndView findRangedSlipList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        String fromDate = request.getParameter("from");
        String toDate = request.getParameter("to");
        ArrayList<SlipBean> slipList = slipServiceFacade.findRangedSlipList(fromDate, toDate);
        modelAndView.addObject("slipList", slipList);

        return modelAndView;
    }


    public ModelAndView findDisApprovalSlipList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        ArrayList<SlipBean> disApprovalSlipList = slipServiceFacade.findDisApprovalSlipList();
        modelAndView.addObject("disApprovalSlipList", disApprovalSlipList);

        return modelAndView;
    }

    public void setSlipServiceFacade(SlipServiceFacade slipServiceFacade) {
        this.slipServiceFacade = slipServiceFacade;
    }
}
