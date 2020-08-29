package entity;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Tytuł")
    private String title;
    @Column(name = "Reżyser")
    private String director;
    @Column(name = "Gatunek")
    private String filmGenre;
    @Column(name = "Rok")
    private Integer productionYear;
    @Column(name = "Obsada")
    private String starsActorsAndActresses;
    @Column(name = "Recenzje")
    private String reviews;

    public MovieEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieEntity(String title, String director, String productionCountry, Integer productionYear) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
    }

    public MovieEntity(Integer id, String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.filmGenre = filmGenre;
        this.productionYear = productionYear;
        this.starsActorsAndActresses = starsActorsAndActresses;
        this.reviews = reviews;
    }

    public MovieEntity(String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
        this.filmGenre = filmGenre;
        this.starsActorsAndActresses = starsActorsAndActresses;
        this.reviews = reviews;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getStarsActorsAndActresses() {
        return starsActorsAndActresses;
    }

    public void setStarsActorsAndActresses(String starsActorsAndActresses) {
        this.starsActorsAndActresses = starsActorsAndActresses;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        System.out.println("Movie Entity:");
        return
                '\n'+"Tytuł='" + this.title + '\'' +
                ", Director='" + this.director + '\'' +
                ", FilmGenre='" + this.filmGenre + '\'' +
                ", Stars=" + this.starsActorsAndActresses +
                ", Reviews=" + this.reviews ;

    }


}