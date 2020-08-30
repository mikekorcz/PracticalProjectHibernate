import entity.MovieEntity;

public class Main {

    public static void main(String[] args) {

//        MovieRepository.save("Top Gun", "Tony Ala", "Sensacyjny, Romans", 1986, "Tom Cruise, Kelly McGillis, Val Kilmer", "Rewelacyjny film!, Emocjonujące walki w powietrzu.");
//        MovieRepository.saveTittle("Golden Eye", "Martin Campbell", "Sensacyjny", 1995, "Pierce Brosnan, Sean Bean, Izabella Scorupco", "Najsłabszy z Bondów");
//        MovieRepository.saveTittle("Mamma Mia!", "Phyllida Lloyd", "Musical, Komedia Romantyczna", 2008, "Meryl Streep, Pierce Brosnan, Colin Firth", "Aż chce się tańczyć!, Mamma Mia! Here I go again!");
//        MovieRepository.saveTittle("Pani Doubtfire", "Chris Columbus", "Dramat, Komedia", 1993, "Robin Williams, Sally Field, Pierce Brosnan", "Hahahahha!");
//        MovieRepository.saveTittle("Ojciec Chrzestny", "Francis Ford Coppola", "Dramat, Gangsterski", 1972, "Marlon Brando, Al Pacino, James Caan", "Strzelaniny cygara i głaskanie kotów, RIP Marlon!");
//        MovieRepository.saveTittle("Forrest Gump", "Robert Zemeckis", "Dramat, Komedia", 1994, "Tom Hanks, Robin Wright, Sally Field", "Tom Hanks, Tom Sizemore, Edward Burns");
//        MovieRepository.saveTittle("Szeregowiec Ryan", "Steven Spielberg", "Dramat, Wojenny", 1998, "Tom Hanks, Tom Sizemore, Edward Burns", "Bardzo emocjonujący film, Gloryfikuje wojnę!");

//        MovieRepository.readAll();

//        MovieRepository.delete( "Top Gun");

    }

    public void movie(String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(title);
        movieEntity.setDirector(director);
        movieEntity.setFilmGenre(filmGenre);
        movieEntity.setProductionYear(productionYear);
        movieEntity.setStarsActorsAndActresses(starsActorsAndActresses);
        movieEntity.setReviews(reviews);
    }
}
