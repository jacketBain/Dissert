package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.Album;
import com.freemscp.model.KeyNote;
import com.freemscp.model.Track;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TrackDAO implements IDao<Track, Integer> {

    public Track findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Track.class, id);
    }


    public List<Track> findTracksByUser(Integer id)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Track> criteriaQuery = criteriaBuilder.createQuery(Track.class);
        Root<Track> root = criteriaQuery.from(Track.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("id_album").get("id_artist"), id));
        try {
            return session.createQuery(criteriaQuery).getResultList();
        }
        catch (NoResultException ex) {
            return null;
        }
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
        session.merge(track);
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
