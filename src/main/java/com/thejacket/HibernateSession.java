package com.thejacket;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * Created by mariusz on 2017-05-11.
 */
public class HibernateSession {

        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
                standardServiceRegistryBuilder.applySettings(configuration.getProperties());
                ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();

                return configuration.buildSessionFactory(serviceRegistry);
            }
            catch(Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }
