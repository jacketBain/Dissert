package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.Album;
import com.freemscp.model.Genre;
import com.freemscp.model.KeyNote;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public KeyNote findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<KeyNote> criteriaQuery = criteriaBuilder.createQuery(KeyNote.class);
        Root<KeyNote> root = criteriaQuery.from(KeyNote.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("keyNote"), name));
        try {
            return session.createQuery(criteriaQuery).getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
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
