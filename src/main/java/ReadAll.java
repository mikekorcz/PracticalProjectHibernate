import configuration.HibernateConfiguration;
import entity.MovieEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReadAll {
    public static void GetData() {

        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session openSession = sessionFactory.openSession();

        try {
            List readAllData =
                    openSession
                            .createQuery("FROM MovieEntity")
                            .list();

//            List<MovieEntity> readAllData =
//                    openSession
//                            .createQuery("FROM MovieEntity")
//                            .list();

            openSession.beginTransaction();

//        openSession.save(readAllData);
            for (Object movieEntity : readAllData) {
                System.out.println(movieEntity);
            }

            openSession.getTransaction().commit();

        } finally {
            openSession.close();
            HibernateConfiguration.closeSessionFactory();
        }


    }
}
