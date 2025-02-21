package org.example.config;


import org.example.entity.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class SessionFactoryInstance {
    public static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure()
               .addAnnotatedClass(User.class)
                .buildSessionFactory();

    }
}