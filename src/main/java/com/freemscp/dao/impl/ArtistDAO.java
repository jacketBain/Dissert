package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.Album;
import com.freemscp.model.Artist;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.criterion.Restrictions;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ArtistDAO implements IDao<Artist, Integer> {

    public Artist findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Artist artist = session.get(Artist.class, id);
        tx1.commit();
        session.close();
        return artist;
    }

    public Artist findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> criteriaQuery = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> root = criteriaQuery.from(Artist.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("login"), login));
        try {
            return session.createQuery(criteriaQuery).getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }

    public void save(Artist artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(artist);
        tx1.commit();
        session.close();
    }

    public void update(Artist artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(artist);
        tx1.commit();
        session.close();
    }
    public void delete(Artist artist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(artist);
        tx1.commit();
        session.close();
    }

    public List<Artist> findAll() {
        List<Artist> artists = (List<Artist>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Artist ").list();
        return artists;
    }

    public boolean isUserExist(String username, String password) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> criteriaQuery = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> root = criteriaQuery.from(Artist.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.and(criteriaBuilder.equal(root.get("password"), password)),
                        criteriaBuilder.equal(root.get("login"), username));
        try {
            session.createQuery(criteriaQuery).getSingleResult();
        }
        catch (NoResultException ex) {
            result = false;
        }
        return result;
    }

}
