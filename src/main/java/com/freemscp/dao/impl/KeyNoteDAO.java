package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.Genre;
import com.freemscp.model.KeyNote;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KeyNoteDAO implements IDao<KeyNote, Integer> {

    public KeyNote findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(KeyNote.class, id);
    }

    public void save(KeyNote keyNote) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(keyNote);
        tx1.commit();
        session.close();
    }

    public void update(KeyNote keyNote) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(keyNote);
        tx1.commit();
        session.close();
    }
    public void delete(KeyNote keyNote) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(keyNote);
        tx1.commit();
        session.close();
    }

    public List<KeyNote> findAll() {
        List<KeyNote> keyNotes = (List<KeyNote>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From KeyNote ").list();
        return keyNotes;
    }

}
