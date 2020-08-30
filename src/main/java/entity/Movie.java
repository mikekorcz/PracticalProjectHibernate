package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {


    //    @Id
    @Column(insertable = false, updatable = false, columnDefinition = "serial", unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "Tytuł")
    private String title;
    @Column(name = "Reżyser")
    private String director;
    @Column(name = "Gatunek")
    private String filmGenre;
    @Column(name = "Rok")
    @Transient
    private Integer productionYear;
    @Column(name = "Obsada")
    @Transient
    private String starsActorsAndActresses;
    @Column(name = "Recenzje")
    @OneToMany
    private List<Review> reviews;
    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie(String title, String director, String filmGenre) {
        this.title = title;
        this.director = director;
        this.filmGenre = filmGenre;
    }

    public Movie(Integer id, String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.filmGenre = filmGenre;
        this.productionYear = productionYear;
        this.starsActorsAndActresses = starsActorsAndActresses;
    }

    public Movie(String title, String director, String filmGenre, Integer productionYear, String starsActorsAndActresses, String reviews) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
        this.filmGenre = filmGenre;
        this.starsActorsAndActresses = starsActorsAndActresses;

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



    @Override
    public String toString() {
        return
                '\n' + "Tytuł='" + this.title + '\'' +
                        ", Director='" + this.director + '\'' +
                        ", FilmGenre='" + this.filmGenre + '\'';

    }


}