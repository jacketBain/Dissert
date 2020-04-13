package com.freemscp;

import com.freemscp.model.Genre;
import com.freemscp.services.GenreService;

public class Main {

    public static void main(String args[])
    {
        GenreService genreService = new GenreService();
        Genre genre = new Genre("Rock");
        genreService.saveGenre(genre);
    }
}
