package net.plang.DYAccount.base.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.base.serviceFacade.CodeListServiceFacade;
import net.plang.DYAccount.base.to.CodeBean;
import net.plang.DYAccount.base.to.DetailCodeBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class CodeListController extends MultiActionController {
    private CodeListServiceFacade codeListServiceFacade;

    public ModelAndView getDetailCodeList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        HashMap<String, String> param = new HashMap<>();

        param.put("divisionCodeNo", request.getParameter("divisionCodeNo"));
        if (request.getParameter("detailCodeName") != null)
            param.put("detailCodeName", request.getParameter("detailCodeName"));

        ArrayList<DetailCodeBean> detailCodeList = codeListServiceFacade.getDetailCodeList(param);
        modelAndView.addObject("detailCodeList", detailCodeList);
        modelAndView.addObject("errorCode", 0);

        return modelAndView;
    }

    public ModelAndView findCodeList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        ArrayList<CodeBean> codeList = codeListServiceFacade.findCodeList();

        modelAndView.addObject("codeList", codeList);
        modelAndView.addObject("errorCode", 0);

        return modelAndView;
    }
    public void setCodeListServiceFacade(CodeListServiceFacade codeListServiceFacade) {
        this.codeListServiceFacade = codeListServiceFacade;
    }
}
