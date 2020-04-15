package com.freemscp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@SequenceGenerator(name = "SEQ_GENRE",sequenceName = "SEQ_GENRE")
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(generator = "SEQ_GENRE")
    @Column(name = "id_genre", nullable = false)
    private int id;


    @Column(name = "genre_name", nullable = false)
    private String genreName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_genre")
    private List<Album> albumList = new LinkedList<Album>();

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
