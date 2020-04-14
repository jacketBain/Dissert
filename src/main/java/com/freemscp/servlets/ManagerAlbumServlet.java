package com.freemscp.servlets;

import com.freemscp.model.Album;
import com.freemscp.model.Artist;
import com.freemscp.services.AlbumService;
import com.freemscp.services.ArtistService;
import com.freemscp.services.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/managerAlbum")
public class ManagerAlbumServlet extends HttpServlet {

    AlbumService albumService = new AlbumService();
    GenreService genreService = new GenreService();
    ArtistService artistService = new ArtistService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("listGenres",genreService.findAllGenres());
        if(req.getParameter("action")!=null && req.getParameter("action").equals("chg"))
        {
            req.setAttribute("chAlbumID",req.getParameter("id_ch"));
            req.setAttribute("chAlbumName",albumService.findAlbum(Integer.parseInt(req.getParameter("id_ch"))).getAlbumName());
            req.setAttribute("chAlbumYear",albumService.findAlbum(Integer.parseInt(req.getParameter("id_ch"))).getAlbumYear());
            req.setAttribute("chAlbumGenre",albumService.findAlbum(Integer.parseInt(req.getParameter("id_ch"))).getId_genre());

            req.getRequestDispatcher("/managerAlbumEdit.jsp").forward(req, resp);

        }
        else if(req.getParameter("action")!=null && req.getParameter("action").equals("add"))
        {
            req.getRequestDispatcher("/managerAlbumAdd.jsp").forward(req, resp);
        }
        else if(req.getParameter("action")!=null && req.getParameter("action").equals("del"))
        {
            Album album = new Album();
            album = albumService.findAlbum(Integer.parseInt(req.getParameter("id_ch")));
            albumService.deleteAlbum(album);
            req.setAttribute("listAlbums", albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId()));
            req.getRequestDispatcher("/managerAlbum.jsp").forward(req, resp);
        }
        else
        {
            req.setAttribute("listAlbums", albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId()));
            req.getRequestDispatcher("/managerAlbum.jsp").forward(req, resp);
        }


    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        HttpSession session = req.getSession();
        Album album = new Album();
        req.setCharacterEncoding("UTF-8");
        switch (req.getParameter("action")) {

            case "change" :
                album.setId(Integer.parseInt(req.getParameter("albumID")));
                album.setId_artist(artistService.findArtistByLogin((String)session.getAttribute("login")));
                album.setAlbumYear(req.getParameter("albumYear"));
                album.setId_genre((genreService.findGenreByName(req.getParameter("albumGenre"))));
                album.setAlbumName(req.getParameter("albumName"));
                albumService.updateAlbum(album);

                req.setAttribute("listAlbums", albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerAlbum.jsp").forward(req, resp);
                break;

            case "add" :

                album.setId_artist(artistService.findArtistByLogin((String)session.getAttribute("login")));

                Date date = new Date();
                SimpleDateFormat formatDate;
                formatDate = new SimpleDateFormat(
                        "yyyy");

                album.setAlbumYear(formatDate.format(date));
                album.setId_genre((genreService.findGenreByName(req.getParameter("albumGenre"))));
                album.setAlbumName(req.getParameter("albumName"));
                albumService.saveAlbum(album);

                req.setAttribute("listAlbums", albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerAlbum.jsp").forward(req, resp);
                break;

            default:
                req.setAttribute("listAlbums", albumService.findAlbumsByUser(artistService.findArtistByLogin((String)session.getAttribute("login")).getId()));
                req.getRequestDispatcher("/managerAlbum.jsp").forward(req, resp);
                break;
        }

    }

}
