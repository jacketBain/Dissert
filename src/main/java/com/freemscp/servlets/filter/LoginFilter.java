package com.freemscp.servlets.filter;

import com.freemscp.services.ArtistService;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private static final ArtistService artistService = new ArtistService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        if (request.getRequestURI().matches("\\S*/resources/\\S*") ||
                (request.getRequestURI().matches("\\S*/register\\S*"))) {
            filterChain.doFilter(request, response);
        } else {
            if (session.getAttribute("login") != null && session.getAttribute("password") != null) {
                filterChain.doFilter(request, response);
            } else {
                String login = request.getParameter("login");
                String password = request.getParameter("password");

                if (login != null || password != null) {
                    if (artistService.isUserExists(login,password)){
                        request.getSession().setAttribute("login", login);
                        request.getSession().setAttribute("password", password);
                        request.getSession().setAttribute("name",artistService.findArtistByLogin(login).getArtistName());
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    else {
                        request.setAttribute("state", 1);
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                }
                else {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
        }
    }
}