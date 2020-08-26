package entity;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class MovieEntity {

    @GeneratedValue
    @Id
    private Integer id;

    private String Title;
    private String Director;
    private String ProductionCountry;
    private Integer ProductionYear;

    public MovieEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieEntity(String title, String director, String productionCountry, Integer productionYear) {
        Title = title;
        Director = director;
        ProductionCountry = productionCountry;
        ProductionYear = productionYear;
    }
    @Column(name = "Title")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
    @Column(name = "Director")
    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }
    @Column(name = "ProductionCountry")
    public String getProductionCountry() {
        return ProductionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        ProductionCountry = productionCountry;
    }
    @Column(name = "ProductionYear")
    public Integer getProductionYear() {
        return ProductionYear;
    }

    public void setProductionYear(Integer productionYear) {
        ProductionYear = productionYear;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "Title='" + Title + '\'' +
                ", Director='" + Director + '\'' +
                ", ProductionCountry='" + ProductionCountry + '\'' +
                ", ProductionYear=" + ProductionYear +
                '}';
    }
}
