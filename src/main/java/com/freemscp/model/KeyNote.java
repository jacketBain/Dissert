package com.freemscp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@SequenceGenerator(name = "SEQ_KYNT", sequenceName = "SEQ_KYNT")
@Entity
@Table(name = "key_note")
public class KeyNote {
    @Id
    @GeneratedValue(generator = "SEQ_KYNT")
    @Column(name = "id_keynote", nullable = false)
    private int id;


    @Column(name = "key_note", nullable = false)
    private String keyNote;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id_keynote")
    private List<Track> trackList = new LinkedList<Track>();

    public KeyNote() {
    }

    public KeyNote(String keyNote) {
        this.keyNote = keyNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyNote() {
        return keyNote;
    }

    public void setKeyNote(String keyNote) {
        this.keyNote = keyNote;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
