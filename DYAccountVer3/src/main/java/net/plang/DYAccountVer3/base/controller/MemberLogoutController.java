package net.plang.DYAccountVer3.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@RestController
public class MemberLogoutController {
    @RequestMapping(value="/logout")
    public void logout(HttpServletRequest request) {


        request.getSession().invalidate();
    }

}
