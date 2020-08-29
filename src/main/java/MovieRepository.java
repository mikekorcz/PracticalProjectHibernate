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
  private static  Session openSession = sessionFactory.openSession();
    public static List<MovieEntity> readAll() {
        List<MovieEntity> entities = new ArrayList<>();
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query<MovieEntity> entities1 = session.createQuery("FROM MovieEntity");
            entities = entities1.list();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            openSession.close();
            HibernateConfiguration.closeSessionFactory();
        }
        System.out.println(entities);
        return entities;

    }

}
