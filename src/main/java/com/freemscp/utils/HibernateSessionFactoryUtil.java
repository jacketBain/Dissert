package com.freemscp.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory==null)
        {
            try
            {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
