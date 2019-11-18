package net.plang.DYAccount.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {
    private String excludePathList;
    private String loginPage;
    private String movePage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String contextPath = filterConfig.getServletContext().getContextPath();

//        excludePathList = filterConfig.getInitParameter("excludeLoginFilter");
        loginPage = filterConfig.getInitParameter("loginPage");
        loginPage = loginPage.startsWith("/") ? contextPath + loginPage : contextPath + "/" + loginPage;

        movePage = filterConfig.getInitParameter("movePage");
        movePage = movePage.startsWith("/") ? contextPath + movePage : contextPath + "/" + movePage;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // .html 파일과 welcome page만 필터링
        if (request.getRequestURI().equals("/") || request.getRequestURI().endsWith(".html")) {

            boolean isLoginPage = request.getRequestURI().equals(loginPage);

            if (isLoginPage && request.getSession().getAttribute("empCode") != null) {
                response.sendRedirect(movePage);
                return;
            }

            if (!isLoginPage && request.getSession().getAttribute("empCode") == null) {
                response.sendRedirect(loginPage);
                return;
            }
        }
        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
