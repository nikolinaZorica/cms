package com.nikolinaspringboot.cms.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/*
Configuring URL Pattern of Filter // u kombinaciji sa MyFilterConfig class-om
 */
@Component
public class MyNewFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("The new filter is called");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
