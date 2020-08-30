import configuration.HibernateConfiguration;
import entity.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private static SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
    private static Session openSession = sessionFactory.openSession();

    public void save(Movie movie) {

        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(movie);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }

    public static List<Movie> readAll() {
        List<Movie> entities = new ArrayList<>();
        try (Session openSession = HibernateConfiguration.getSessionFactory().openSession()) {
            Transaction transaction = openSession.beginTransaction();
            Query<Movie> entities1 = openSession.createQuery("FROM MovieEntity");
            entities = entities1.list();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            openSession.close();
            HibernateConfiguration.closeSessionFactory();
        }
        System.out.println(entities);
        return entities;
    }

    public static void delete(String title) {
        Session openSession = null;
        try {
            openSession = sessionFactory.openSession();
            Transaction transaction = openSession.beginTransaction();
            Movie toRemove = openSession.get(Movie.class, title);
            openSession.delete(toRemove);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }


}
