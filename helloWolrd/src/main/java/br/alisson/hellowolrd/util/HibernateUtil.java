package br.alisson.hellowolrd.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author alisson
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    private static final String HIBERNATE_SESSION = "hibernate_session";
    
    
    static{
        try {
            System.out.println("Traing to open a SF...");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry sr = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(sr);
            System.out.println("SF Initialized!");
            
        } catch (Exception e) {
            System.out.println("Error while try to connect to SF! "+e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
