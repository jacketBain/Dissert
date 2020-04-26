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

@WebServlet("/player")
public class PlayMP3Servlet extends HttpServlet {

    TrackService trackService = new TrackService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        Track track = trackService.findTrack(Integer.parseInt(req.getParameter("id_playable")));
        //byte[] mp3file = track.getFileMP3();
        //int mp3fileLength = mp3file.length;
        ServletContext context = getServletContext();
        ServletOutputStream out = resp.getOutputStream();
        resp.setContentType("audio/mpeg3");
        resp.setContentLength(track.getFileMP3().length);
        resp.setHeader("Content-disposition", "attachment; filename=mymp3filename.mp3");
        resp.setHeader("accept-ranges:", "bytes");
        //resp.setHeader("Content-Length:", String.valueOf(track.getFileMP3().length));
       // resp.setHeader("Content-Range:", "bytes 0-"+ (track.getFileMP3().length - 1) +"/"+ track.getFileMP3().length);
        //resp.setHeader("Content-Type:", "audio/mpeg3");
       // resp.setHeader("Content-Transfer-Encoding:", "binary");
        out.write(track.getFileMP3());
        out.flush();
        out.close();
    }
}
