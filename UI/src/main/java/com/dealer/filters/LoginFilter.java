package com.dealer.filters;
import com.dealer.dto.Dealer;

import javax.servlet.*;
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

        String loginDealer = ((Dealer)session.getAttribute("dealer")).getDealerName();
        String loginRole = ((Dealer)session.getAttribute("dealer")).getRole();

        if (loginDealer == null) {
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
            ((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/pages/login.xhtml");
        }

        if(!loginRole.equals("ADMIN")){

            String criticalPath = ((HttpServletRequest) servletRequest).getServletPath();
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
            if(criticalPath.endsWith("import.xhtml")){
                ((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/pages/login.xhtml");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
