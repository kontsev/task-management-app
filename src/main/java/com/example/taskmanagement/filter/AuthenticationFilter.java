package com.example.taskmanagement.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        String regex = "\\(\\d+\\)$";
        HttpServletRequest request = (HttpServletRequest)arg0;
        if(request.getRequestURI().startsWith("/TaskManagement_war_exploded/edit")||
                request.getRequestURI().startsWith("/TaskManagement_war_exploded/new") ||
                request.getRequestURI().startsWith("/TaskManagement_war_exploded/edit?=" + regex) ||
                request.getRequestURI().startsWith("/TaskManagement_war_exploded/list")){
            HttpSession session = request.getSession();
            if(session.getAttribute("username")==null){
                request.getRequestDispatcher("/html/login.jsp").forward(request, arg1);
            }
        }
        arg2.doFilter(request, arg1);
    }
}