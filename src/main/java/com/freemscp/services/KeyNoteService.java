package com.freemscp.services;

import com.freemscp.dao.impl.KeyNoteDAO;
import com.freemscp.model.Genre;
import com.freemscp.model.KeyNote;

import java.util.List;

public class KeyNoteService {

    private KeyNoteDAO keyNoteDAO = new KeyNoteDAO();

    public KeyNoteService() {
    }

    public KeyNote findKeyNote(int id) {
        return keyNoteDAO.findById(id);
    }

    public KeyNote findKeyNoteByName(String name)
    {
        return keyNoteDAO.findByName(name);
    }

    public void saveKeyNote(KeyNote keyNote) {
        keyNoteDAO.save(keyNote);
    }

    public void deleteKeyNote(KeyNote keyNote) {
        keyNoteDAO.delete(keyNote);
    }

    public void updateKeyNote(KeyNote keyNote) {
        keyNoteDAO.update(keyNote);
    }

    public List<KeyNote> findKeyNotes() {
        return keyNoteDAO.findAll();
    }

}
