package net.plang.DYAccount.base.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController extends AbstractController {
    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("jsonView");

        request.getSession().invalidate();
        modelAndView.addObject("errorCode", 0);
        modelAndView.addObject("errorMsg", "로그아웃 성공");

        return modelAndView;
    }

}
