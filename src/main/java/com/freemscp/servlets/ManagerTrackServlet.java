package com.freemscp.servlets;


import com.freemscp.model.Album;
import com.freemscp.model.Artist;
import com.freemscp.model.KeyNote;
import com.freemscp.model.Track;
import com.freemscp.services.AlbumService;
import com.freemscp.services.ArtistService;
import com.freemscp.services.KeyNoteService;
import com.freemscp.services.TrackService;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileFormat;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.hibernate.type.BlobType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sound.sampled.*;
import java.io.*;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@WebServlet("/managerTrack")
@MultipartConfig
public class ManagerTrackServlet  extends HttpServlet {

    ArtistService artistService = new ArtistService();
    AlbumService albumService = new AlbumService();
    KeyNoteService keyNoteService = new KeyNoteService();
    TrackService trackService = new TrackService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("listKeys",keyNoteService.findKeyNotes());
        req.setAttribute("listAlbums", albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId()));
        if(req.getParameter("action")!=null && req.getParameter("action").equals("chg"))
        {
            req.setAttribute("chTrackID",req.getParameter("id_ch"));
            req.setAttribute("chTrackName",trackService.findTrack(Integer.parseInt(req.getParameter("id_ch")))
                                                                                    .getTrackName());
            req.setAttribute("chTrackAlbum",trackService.findTrack(Integer.parseInt(req.getParameter("id_ch")))
                    .getId_album().getAlbumName());
            req.setAttribute("chTrackKey",trackService.findTrack(Integer.parseInt(req.getParameter("id_ch")))
                    .getId_keynote().getKeyNote());
            req.setAttribute("chTrackBPM",trackService.findTrack(Integer.parseInt(req.getParameter("id_ch")))
                    .getBpm());
            req.getRequestDispatcher("/managerTrackEdit.jsp").forward(req, resp);
        }
        else if(req.getParameter("action")!=null && req.getParameter("action").equals("add"))
        {
            req.getRequestDispatcher("/managerTrackAdd.jsp").forward(req, resp);
        }
        else if(req.getParameter("action")!=null && req.getParameter("action").equals("del"))
        {
            Track track = new Track();
            track = trackService.findTrack(Integer.parseInt(req.getParameter("id_ch")));
            trackService.deleteTrack(track);
            req.setAttribute("listTracks",trackService.findTracksByUser(artistService.findArtistByLogin((String)session
                    .getAttribute("login")).getId()));
            req.getRequestDispatcher("/managerTrack.jsp").forward(req, resp);

        }
        else
        {
            List<Album> albumList = albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId());
            if(albumList.size()==0) {
                req.getRequestDispatcher("/managerNoAlbum.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("listTracks",trackService.findTracksByUser(artistService.findArtistByLogin((String)session
                        .getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerTrack.jsp").forward(req, resp);
            }
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        HttpSession session = req.getSession();
        Track track = new Track();
        req.setCharacterEncoding("UTF-8");
        switch (req.getParameter("action"))
        {
            case "change":
                track.setId(Integer.parseInt(req.getParameter("trackID")));
                track.setId_album(albumService.findAlbumByName(req.getParameter("trackAlbum")));
                track.setBpm(Short.parseShort(req.getParameter("trackBPM")));
                track.setId_keynote(keyNoteService.findKeyNoteByName(req.getParameter("trackKeyNote")));
                track.setTrackName(req.getParameter("trackName"));
                track.setTrackTime(trackService.findTrack(Integer.parseInt(req.getParameter("trackID"))).getTrackTime());
                track.setFileMP3(trackService.findTrack(Integer.parseInt(req.getParameter("trackID"))).getFileMP3());
                trackService.updateTrack(track);

                req.setAttribute("listTracks",trackService.findTracksByUser(artistService.findArtistByLogin((String)session
                        .getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerTrack.jsp").forward(req, resp);
                break;

            case "add":
                track.setId_album(albumService.findAlbumByName(req.getParameter("trackAlbum")));
                track.setBpm(Short.parseShort(req.getParameter("trackBPM")));
                track.setId_keynote(keyNoteService.findKeyNoteByName(req.getParameter("trackKeyNote")));
                track.setTrackName(req.getParameter("trackName"));



                Part filePart = req.getPart("trackMP3"); // Retrieves <input type="file" name="file">
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                File file = new File(fileName);
                byte[] mp3file = new byte[(int)filePart.getSize()];
                InputStream fileContent = filePart.getInputStream();
                fileContent.read(mp3file);

                track.setFileMP3(mp3file);

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(mp3file);

                try
                {
                    AudioFileFormat audioFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
                    Map properties = audioFileFormat.properties();
                    Long duration = (Long)properties.get("duration")/1000000;
                    track.setTrackTime(new SimpleDateFormat("mm:ss").format(new Date(TimeUnit.SECONDS.toMillis(duration))));

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                trackService.saveTrack(track);
                req.setAttribute("listTracks",trackService.findTracksByUser(artistService.findArtistByLogin((String)session
                        .getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerTrack.jsp").forward(req, resp);
                break;

            default:
                req.setAttribute("listTracks",trackService.findTracksByUser(artistService.findArtistByLogin((String)session
                        .getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerTrack.jsp").forward(req, resp);
                break;

        }
    }


}
