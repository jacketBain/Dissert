package com.freemscp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SequenceGenerator(name = "SEQ_ARTST",sequenceName = "SEQ_ARTST")
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(generator = "SEQ_ARTST")
    @Column(name = "id_artist", nullable = false)
    private int id;


    @Column(name = "artist_name", nullable = false)
    private String artistName;


    @Column(name = "login", nullable = false)
    private String login;


    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "dateRegestration", nullable = false)
    private Date dateReg;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_artist")
    private List<Album> albumList = new LinkedList<Album>();

    public Artist() {
    }

    public Artist(String artistName, String login, String password, Date dateReg) {
        this.artistName = artistName;
        this.login = login;
        this.password = password;
        this.dateReg = dateReg;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
