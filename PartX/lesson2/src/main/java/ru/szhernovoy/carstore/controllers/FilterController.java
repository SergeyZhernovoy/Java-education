package ru.szhernovoy.carstore.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by admin on 19.01.2017.
 */
public class FilterController implements Filter {
    private final static Logger log = LoggerFactory.getLogger(FilterController.class);
    private String encoding = "utf-8";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setContentType(String.format("text/json;charset=%s",encoding));
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
