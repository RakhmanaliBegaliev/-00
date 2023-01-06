package com.peaksoft.util;

import com.peaksoft.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory = builSessionFactory();

    private static SessionFactory builSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Passport.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(Shop.class)
                    .addAnnotatedClass(Smartphone.class)
                    .addAnnotatedClass(University.class)
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(Laptop.class)
                    .addAnnotatedClass(Transport.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw e;
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
