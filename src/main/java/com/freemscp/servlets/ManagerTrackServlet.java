package com.freemscp.servlets;


import com.freemscp.services.AlbumService;
import com.freemscp.services.TrackService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerTrackServlet  extends HttpServlet {

    TrackService trackService = new TrackService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();

        req.setAttribute("listTracks",trackService.findAllTracks());

        req.getRequestDispatcher("/managerTrack.jsp").forward(req, resp);


    }


}
