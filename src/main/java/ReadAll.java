import configuration.HibernateConfiguration;
import entity.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReadAll {
    public static void GetData() {

        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session openSession = sessionFactory.openSession();

        try {
//            List readAllData =
//                    openSession
//                            .createQuery("FROM MovieEntity")
//                            .list();
            openSession.beginTransaction();
            List<MovieEntity> readAllData =
                    openSession
                            .createQuery("FROM MovieEntity")
                            .list();



// openSession.save(readAllData);
            for (MovieEntity movieEntity : readAllData) {
                System.out.println(movieEntity);
            }

            openSession.getTransaction().commit();

        } finally {
            openSession.close();
            HibernateConfiguration.closeSessionFactory();
        }


    }
}
