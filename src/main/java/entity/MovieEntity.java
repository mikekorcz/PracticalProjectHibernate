package entity;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class MovieEntity {

    @GeneratedValue
    @Id
    private Integer id;

    private String title;
    private String director;
    private String filmGenre;
    private Integer productionYear;
    private String starsActorsAndActresses;
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

    public MovieEntity(String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
        this.filmGenre = filmGenre;
        this.starsActorsAndActresses = starsActorsAndActresses;
        this.reviews = reviews;

    }



    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "Director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "FilmGenre")
    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    @Column(name = "ProductionYear")
    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    @Column(name = "Stars")
    public String getStarsActorsAndActresses() {
        return starsActorsAndActresses;
    }

    public void setStarsActorsAndActresses(String starsActorsAndActresses) {
        this.starsActorsAndActresses = starsActorsAndActresses;
    }

    @Column(name = "Reviews")
    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

        @Override
    public String toString() {
        return "MovieEntity{" +
                "Title='" + this.title + '\'' +
                ", Director='" + this.director + '\'' +
                ", FilmGenre='" + this.filmGenre + '\'' +
                ", Stars=" + this.starsActorsAndActresses +
                ", Reviews=" + this.reviews +
                '}';
    }


}