package com.freemscp.services;

import com.freemscp.dao.impl.TrackDAO;
import com.freemscp.model.Track;

import java.util.List;

public class TrackService {
    private TrackDAO trackDAO = new TrackDAO();

    public TrackService() {
    }

    public Track findTrack(int id) {
        return trackDAO.findById(id);
    }

    public void saveTrack(Track track) {
        trackDAO.save(track);
    }

    public void deleteTrack(Track track) {
        trackDAO.delete(track);
    }

    public void updateTrack(Track track) {
        trackDAO.update(track);
    }

    public List<Track> findAllTracks() {
        return trackDAO.findAll();
    }

}
