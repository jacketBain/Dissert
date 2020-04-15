package com.freemscp.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SequenceGenerator(name = "SEQ_ALBUM",sequenceName = "SEQ_ALBUM")
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(generator = "SEQ_ALBUM")
    @Column(name = "id_album", nullable = false)
    private int id;


    @Column(name = "album_name", nullable = false)
    private String albumName;


    @Column(name = "album_year", nullable = false)
    private String albumYear;


    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist id_artist;


    @ManyToOne
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre id_genre;

    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "id_album")
    private List<Track> trackList = new LinkedList<Track>();

    public Album() {
    }

    public Album(String albumName, String albumYear, Artist id_artist, Genre id_genre) {
        this.albumName = albumName;
        this.albumYear = albumYear;
        this.id_artist = id_artist;
        this.id_genre = id_genre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(String albumYear) {
        this.albumYear = albumYear;
    }

    public Artist getId_artist() {
        return id_artist;
    }

    public void setId_artist(Artist id_artist) {
        this.id_artist = id_artist;
    }

    public void setId_genre(Genre id_genre) {
        this.id_genre = id_genre;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Genre getId_genre() {
        return id_genre;
    }
}
