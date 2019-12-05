package com.zzh.client.filter;

import com.zzh.client.entity.Admin;
import com.zzh.client.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/main.html"},filterName = "adminFilter")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest= (HttpServletRequest) request;
        HttpServletResponse servletResponse= (HttpServletResponse) response;
        HttpSession session=servletRequest.getSession();
        Admin admin= (Admin) session.getAttribute("admin");
        if (admin==null){
            servletResponse.sendRedirect("login.html");
        }else {
            chain.doFilter(request,response);
        }
    }
    @Override
    public void destroy() {

    }
}
