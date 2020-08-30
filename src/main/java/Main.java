import configuration.HibernateConfiguration;
import entity.Movie;

import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepository();
        //      Movie movie = new Movie("Golden Eye", "Martin Campbell", "Akcji");

        List<Movie> movie = movieRepository.readAll();

        System.out.println(movie);

//        MovieRepository.delete( "Golden Eye");
//movieRepository.save(movie);
        HibernateConfiguration.closeSessionFactory();
    }
}
