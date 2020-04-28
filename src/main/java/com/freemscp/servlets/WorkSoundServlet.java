package com.freemscp.servlets;

import com.freemscp.model.Track;
import com.freemscp.services.TrackService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/workSound")
public class WorkSoundServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameter("id")!=null)
        {
            TrackService trackService = new TrackService();
            req.setAttribute("id_play",req.getParameter("id"));
            req.setAttribute("titlePlayer",trackService.findTrack(Integer.parseInt(req.getParameter("id"))).getTrackName());
            req.setAttribute("albumPlayer",trackService.findTrack(Integer.parseInt(req.getParameter("id"))).getId_album().getAlbumName());
            req.setAttribute("artistPlayer",trackService.findTrack(Integer.parseInt(req.getParameter("id"))).getId_album().getId_artist().getArtistName());
            req.setAttribute("durPlayer",trackService.findTrack(Integer.parseInt(req.getParameter("id"))).getTrackTime());
            req.getRequestDispatcher("/workSound.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/workSound.jsp").forward(req, resp);
        }
    }

}
