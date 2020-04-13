package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.KeyNote;
import com.freemscp.model.Track;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class TrackDAO implements IDao<Track, Integer> {

    public Track findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Track.class, id);
    }

    public void save(Track track) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(track);
        tx1.commit();
        session.close();
    }

    public void update(Track track) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(track);
        tx1.commit();
        session.close();
    }
    public void delete(Track track) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(track);
        tx1.commit();
        session.close();
    }

    public List<Track> findAll() {
        List<Track> tracks = (List<Track>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Track ").list();
        return tracks;
    }

}
