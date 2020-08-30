import entity.MovieEntity;
import configuration.HibernateConfiguration;
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

    public static void saveTittle(String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {
        try {
            openSession = sessionFactory.openSession();

            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setTitle(title);
            movieEntity.setDirector(director);
            movieEntity.setFilmGenre(filmGenre);
            movieEntity.setProductionYear(productionYear);
            movieEntity.setStarsActorsAndActresses(starsActorsAndActresses);
            movieEntity.setReviews(reviews);

            openSession.beginTransaction();
            openSession.save(movieEntity);
            openSession.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
    }

    public static List<MovieEntity> readAll() {
        List<MovieEntity> entities = new ArrayList<>();
        try (Session openSession = HibernateConfiguration.getSessionFactory().openSession()) {
            Transaction transaction = openSession.beginTransaction();
            Query<MovieEntity> entities1 = openSession.createQuery("FROM MovieEntity");
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
            MovieEntity toRemove = openSession.get(MovieEntity.class, title);
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

    public static void update(MovieEntity toUpdate) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            MovieEntity updated = session.get(MovieEntity.class, toUpdate.getId());
            session.evict(updated);
            session.saveOrUpdate(toUpdate);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static String save(MovieEntity toCreate) {
        Session openSession = null;
        String title = null;
        try {
            openSession = sessionFactory.openSession();
            Transaction transaction = openSession.beginTransaction();
            title = (String) openSession.save(toCreate);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (openSession != null) {
                openSession.close();
            }
        }
        return title;
    }


}
