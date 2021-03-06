package com.freemscp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.sql.Time;

@SequenceGenerator(name = "SEQ_TRCK", sequenceName = "SEQ_TRCK")
@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(generator = "SEQ_TRACK")
    @Column(name = "id_track", nullable = false)
    private int id;


    @Column(name = "track_name", nullable = false)
    private String trackName;


    @Column(name = "track_time", nullable = false)
    private String trackTime;


    @Column(name = "bpm", nullable = false)
    private short bpm;


    @Lob
    @Column(name = "file_mp3", nullable = false)
    private byte[] fileMP3;


    @ManyToOne
    @JoinColumn(name = "id_keynote", nullable = false)
    private KeyNote id_keynote;


    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album id_album;

    public Track() {
    }

    public Track(String trackName, String trackTime, short bpm, byte[] fileMP3, KeyNote id_keynote, Album id_album) {
        this.trackName = trackName;
        this.trackTime = trackTime;
        this.bpm = bpm;
        this.fileMP3 = fileMP3;
        this.id_keynote = id_keynote;
        this.id_album = id_album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(String trackTime) {
        this.trackTime = trackTime;
    }

    public short getBpm() {
        return bpm;
    }

    public void setBpm(short bpm) {
        this.bpm = bpm;
    }

    public byte[] getFileMP3() {
        return fileMP3;
    }

    public void setFileMP3(byte[] fileMP3) {
        this.fileMP3 = fileMP3;
    }

    public KeyNote getId_keynote() {
        return id_keynote;
    }

    public void setId_keynote(KeyNote id_keynote) {
        this.id_keynote = id_keynote;
    }

    public Album getId_album() {
        return id_album;
    }

    public void setId_album(Album id_album) {
        this.id_album = id_album;
    }
}
