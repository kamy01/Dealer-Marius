package com.dealer.filters;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String loginDealer = (String) session.getAttribute("dealer");

        if (loginDealer == null) {
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
            ((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/pages/login.xhtml");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
