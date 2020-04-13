package com.freemscp.services;

import com.freemscp.dao.impl.GenreDAO;
import com.freemscp.model.Genre;

import java.util.List;

public class GenreService {


    private GenreDAO genreDAO = new GenreDAO();

    public GenreService() {
    }

    public Genre findGenre(int id) {
        return genreDAO.findById(id);
    }

    public Genre findGenreByName(String name)
    {
        return genreDAO.findByName(name);
    }

    public void saveGenre(Genre genre) {
        genreDAO.save(genre);
    }

    public void deleteGenre(Genre genre) {
        genreDAO.delete(genre);
    }

    public void updateGenre(Genre genre) {
        genreDAO.update(genre);
    }

    public List<Genre> findAllGenres() {
        return genreDAO.findAll();
    }

}
