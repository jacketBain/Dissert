package com.freemscp.servlets;


import com.freemscp.model.Artist;
import com.freemscp.services.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class RegistrationServlet extends HttpServlet {
    private static final ArtistService artistService = new ArtistService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameArtist");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        if (login != null || password != null || password2 != null) {
            if (artistService.findArtistByLogin(login)!=null) {
                req.setAttribute("state", 2);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
            else if (!Objects.equals(password, password2)) {
                req.setAttribute("state", 3);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
            else {
                Artist artist = new Artist();
                artist.setArtistName(name);
                artist.setDateReg(new Date());
                artist.setLogin(login);
                artist.setPassword(password);
                artistService.saveArtist(artist);
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
        else {
            req.setAttribute("state",4);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}