package ru.szhernovoy.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 11.12.2016.
 */
public class AuthFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if(req.getRequestURI().contains("/signin")) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpSession httpSession = (HttpSession) req.getSession();
            if(httpSession.getAttribute("login") == null){
                ((HttpServletResponse)servletResponse).sendRedirect(String.format("%s/signin",req.getContextPath()));
                return;
                }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
