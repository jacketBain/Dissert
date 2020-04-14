package com.freemscp.services;

import com.freemscp.dao.impl.AlbumDAO;
import com.freemscp.model.Album;
import com.freemscp.model.Genre;

import java.util.List;

public class AlbumService {

    private AlbumDAO albumDAO = new AlbumDAO();

    public AlbumService() {
    }

    public Album findAlbum(int id) {
        return albumDAO.findById(id);
    }

    public Album findAlbumByName(String name)
    {
        return albumDAO.findByName(name);
    }

    public List<Album> findAlbumsByUser (Integer id) { return albumDAO.findAlbumsByUser(id);}

    public void saveAlbum(Album album) {
        albumDAO.save(album);
    }

    public void deleteAlbum(Album album) {
        albumDAO.delete(album);
    }

    public void updateAlbum(Album album) {
        albumDAO.update(album);
    }

    public List<Album> findAllAlbums() {
        return albumDAO.findAll();
    }

}
