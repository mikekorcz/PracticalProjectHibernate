import entity.Movie;

public class Main {

    public static void main(String[] args) {
MovieRepository movieRepository = new MovieRepository();
        Movie movie = new Movie("Golden Eye", "Martin Campbell", "Akcji");

//        MovieRepository.readAll();

//        MovieRepository.delete( "Top Gun");
movieRepository.save(movie);
    }
}
