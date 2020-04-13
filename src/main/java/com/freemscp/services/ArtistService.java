package com.freemscp.services;

import com.freemscp.dao.impl.ArtistDAO;
import com.freemscp.model.Artist;

import java.util.List;

public class ArtistService {

    private ArtistDAO artistDAO = new ArtistDAO();

    public ArtistService() {
    }

    public Artist findArtist(int id) {
        return artistDAO.findById(id);
    }

    public void saveArtist(Artist artist) {
        artistDAO.save(artist);
    }

    public void deleteArtist(Artist artist) {
        artistDAO.delete(artist);
    }

    public void updateArtist(Artist artist) {
        artistDAO.update(artist);
    }

    public List<Artist> findAllArtists() {
        return artistDAO.findAll();
    }

    public boolean isUserExists(String userName, String password) {return artistDAO.isUserExist(userName, password); }

    public Artist findArtistByLogin(String login) {return artistDAO.findByLogin(login);}

}
