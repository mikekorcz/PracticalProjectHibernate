import configuration.HibernateConfiguration;
import entity.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveTittle {

    public static void saveTittle() {

        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session openSession = sessionFactory.openSession();

        try {
//            MovieEntity starWars = new MovieEntity("Star Wars", "George Lucas", "USA", 1977);
            MovieEntity topGun = new MovieEntity("Top Gun", "Tony Scott", "Sensacyjny, Romans", 1986, "Tom Cruise, Kelly McGillis, Val Kilmer", "Rewelacyjny film!, Emocjonujące walki w powietrzu.");
            MovieEntity goldenEye = new MovieEntity("Golden Eye", "Martin Campbell", "Sensacyjny", 1995, "Pierce Brosnan, Sean Bean, Izabella Scorupco", "Najsłabszy z Bondów");
            MovieEntity mammaMia = new MovieEntity("Mamma Mia!", "Phyllida Lloyd", "Musical, Komedia Romantyczna", 2008, "Meryl Streep, Pierce Brosnan, Colin Firth", "Aż chce się tańczyć!, Mamma Mia! Here I go again!");
            MovieEntity paniDoubtfire = new MovieEntity("Pani Doubtfire", "Chris Columbus", "Dramat, Komedia", 1993, "Robin Williams, Sally Field, Pierce Brosnan", "Hahahahha!");
            MovieEntity godFather = new MovieEntity("Ojciec Chrzestny", "Francis Ford Coppola", "Dramat, Gangsterski", 1972, "Marlon Brando, Al Pacino, James Caan", "Strzelaniny cygara i głaskanie kotów, RIP Marlon!");
            MovieEntity forestGump = new MovieEntity("Forrest Gump", "Robert Zemeckis", "Dramat, Komedia", 1994, "Tom Hanks, Robin Wright, Sally Field", "Tom Hanks, Tom Sizemore, Edward Burns");
            MovieEntity savingPrivateRyan = new MovieEntity("Szeregowiec Ryan", "Steven Spielberg", "Dramat, Wojenny", 1998, "Tom Hanks, Tom Sizemore, Edward Burns", "Bardzo emocjonujący film, Gloryfikuje wojnę!");


            openSession.beginTransaction();

            System.out.println("Adding Top Gun Movie");
            openSession.save(topGun);
            System.out.println("Koniec");
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

}

