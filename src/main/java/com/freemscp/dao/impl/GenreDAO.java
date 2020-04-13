package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.Artist;
import com.freemscp.model.Genre;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenreDAO implements IDao<Genre, Integer> {

    public Genre findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Genre.class, id);
    }

    public Genre findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Genre> criteriaQuery = criteriaBuilder.createQuery(Genre.class);
        Root<Genre> root = criteriaQuery.from(Genre.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("genreName"), name));
        try {
            return session.createQuery(criteriaQuery).getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }

    public void save(Genre genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(genre);
        tx1.commit();
        session.close();
    }

    public void update(Genre genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(genre);
        tx1.commit();
        session.close();
    }
    public void delete(Genre genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(genre);
        tx1.commit();
        session.close();
    }

    public List<Genre> findAll() {
        List<Genre> genres = (List<Genre>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Genre ",Genre.class).list();
        return genres;
    }

}
