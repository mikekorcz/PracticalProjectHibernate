import configuration.HibernateConfiguration;
import entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
    private Session openSession = sessionFactory.openSession();
public void saveRev(Review review){

}
    public void save(Movie movie) {
        Session openSession = null;
        try {
            openSession = sessionFactory.openSession();
            Transaction transaction = openSession.beginTransaction();
            openSession.saveOrUpdate(movie);
            transaction.commit();
            openSession.close();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }

    public List<Movie> readAll() {
        List<Movie> entities = new ArrayList<>();
        try (Session openSession = HibernateConfiguration.getSessionFactory().openSession()) {
            Transaction transaction = openSession.beginTransaction();
            Query<Movie> entities1 = openSession.createQuery("FROM Movie");
            entities = entities1.list();
            transaction.commit();

        } finally {
            openSession.close();

        }

        return entities;
    }

    public void delete(String title) {
        Session openSession = null;
        try {
            openSession = sessionFactory.openSession();
            Transaction transaction = openSession.beginTransaction();
            Movie toRemove = openSession.get(Movie.class, title);
            openSession.delete(toRemove);
            transaction.commit();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }


}
