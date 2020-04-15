package com.freemscp.servlets;

import com.freemscp.model.Track;
import com.freemscp.services.TrackService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/playerTracks")
public class MusicPlayerServlet extends HttpServlet {

    TrackService trackService = new TrackService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        req.setAttribute("listTracks",trackService.findAllTracks());
        req.getRequestDispatcher("/playerTracks.jsp").forward(req, resp);
    }
}
