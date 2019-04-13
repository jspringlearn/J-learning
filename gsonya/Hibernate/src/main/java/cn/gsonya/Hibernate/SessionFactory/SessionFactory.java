package cn.gsonya.Hibernate.SessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactory {
	
	private static org.hibernate.SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration().configure();
	static {
	 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	 session = sessionFactory.openSession();
	 transaction = session.beginTransaction();
	}

    private SessionFactory() {
    }
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }

        return session;
    }
    public static void rebuildSessionFactory() {
     Configuration configuration = new Configuration().configure();
   	 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
   	 session = sessionFactory.openSession();
   	 transaction = session.beginTransaction();
    }
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Configuration getConfiguration() {
        return configuration;
    }

}
