package com.peaksoft.util;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Employee;
import com.peaksoft.entity.Passport;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory = builSessionFactory();

    private static SessionFactory builSessionFactory() {
        Configuration configuration = null;
        try {
            return new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Passport.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(Course.class)
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
