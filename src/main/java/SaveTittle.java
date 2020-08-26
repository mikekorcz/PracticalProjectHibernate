import configuration.HibernateConfiguration;
import entity.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveTittle {

    public static void saveTittle() {

        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session openSession = sessionFactory.openSession();

        try {
            MovieEntity starWars = new MovieEntity("Star Wars", "George Lucas", "USA", 1977);

            openSession.beginTransaction();

            openSession.save(starWars);

            openSession.getTransaction().commit();

        } finally {
            openSession.close();
            HibernateConfiguration.closeSessionFactory();
        }
    }

}

