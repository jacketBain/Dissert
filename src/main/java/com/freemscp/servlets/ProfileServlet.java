package com.freemscp.servlets;

import com.freemscp.services.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    ArtistService artistService = new ArtistService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();
        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat(
                "dd.MM.yyyy");

        session.setAttribute("dateReg",formatDate.format(
                artistService.findArtistByLogin((String)session.getAttribute("login")).getDateReg()));

        req.getRequestDispatcher("/profile.jsp").forward(req, resp);


    }


}
