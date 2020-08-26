import entity.MovieEntity;
import configuration.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

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

//        MovieEntity movieEntity = new MovieEntity();
//        movieEntity.setTitle("Star Wars");
//        Long title = (Long) session.save(movieEntity);

    }
}
