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

    public static void saveTittle() {
        try {
            MovieEntity topGun = new MovieEntity("Top Gun", "Tony Scott", "Sensacyjny, Romans", 1986, "Tom Cruise, Kelly McGillis, Val Kilmer", "Rewelacyjny film!, Emocjonujące walki w powietrzu.");
            MovieEntity goldenEye = new MovieEntity("Golden Eye", "Martin Campbell", "Sensacyjny", 1995, "Pierce Brosnan, Sean Bean, Izabella Scorupco", "Najsłabszy z Bondów");
            MovieEntity mammaMia = new MovieEntity("Mamma Mia!", "Phyllida Lloyd", "Musical, Komedia Romantyczna", 2008, "Meryl Streep, Pierce Brosnan, Colin Firth", "Aż chce się tańczyć!, Mamma Mia! Here I go again!");
            MovieEntity paniDoubtfire = new MovieEntity("Pani Doubtfire", "Chris Columbus", "Dramat, Komedia", 1993, "Robin Williams, Sally Field, Pierce Brosnan", "Hahahahha!");
            MovieEntity godFather = new MovieEntity("Ojciec Chrzestny", "Francis Ford Coppola", "Dramat, Gangsterski", 1972, "Marlon Brando, Al Pacino, James Caan", "Strzelaniny cygara i głaskanie kotów, RIP Marlon!");
            MovieEntity forestGump = new MovieEntity("Forrest Gump", "Robert Zemeckis", "Dramat, Komedia", 1994, "Tom Hanks, Robin Wright, Sally Field", "Tom Hanks, Tom Sizemore, Edward Burns");
            MovieEntity savingPrivateRyan = new MovieEntity("Szeregowiec Ryan", "Steven Spielberg", "Dramat, Wojenny", 1998, "Tom Hanks, Tom Sizemore, Edward Burns", "Bardzo emocjonujący film, Gloryfikuje wojnę!");


            openSession.beginTransaction();

            openSession.save(topGun);
            openSession.save(goldenEye);
            openSession.save(mammaMia);
            openSession.save(paniDoubtfire);
            openSession.save(godFather);
            openSession.save(forestGump);
            openSession.save(savingPrivateRyan);

            openSession.getTransaction().commit();

        } finally {
            openSession.close();
            HibernateConfiguration.closeSessionFactory();
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
