package entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Recenzje")
public class Review {

    @OneToMany(mappedBy = "Review")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Review(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Review() {
    }


}
