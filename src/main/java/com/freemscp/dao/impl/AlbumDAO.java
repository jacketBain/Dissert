package com.freemscp.dao.impl;

import com.freemscp.dao.IDao;
import com.freemscp.model.Album;
import com.freemscp.services.AlbumService;
import com.freemscp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class AlbumDAO implements IDao<Album, Integer> {

    public Album findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Album album = session.get(Album.class, id);
        tx1.commit();
        session.close();
        return album;
    }

    public void save(Album album) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(album);
        tx1.commit();
        session.close();
    }

    public void update(Album album) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(album);
        tx1.commit();
        session.close();
    }
    public void delete(Album album) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(album);
        tx1.commit();
        session.close();
    }

    public List<Album> findAll() {
        List<Album> albums = (ArrayList<Album>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Album ",Album.class).list();
        return albums;
    }

}
