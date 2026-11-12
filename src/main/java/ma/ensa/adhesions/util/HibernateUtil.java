package ma.ensa.adhesions.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    private static SessionFactory factory;

    private HibernateUtil() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return factory;
    }

    public static synchronized void shutdown() {
        if (factory != null) {
            factory.close();
            factory = null;
        }
    }
}