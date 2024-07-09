package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoGame {
    private int id;
    private String name;
    private String releaseDate;
    private String reviewScore;
    private String category;
    private String rating;

    public VideoGame(int id, String name, String releaseDate, String reviewScore, String category, String rating) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.reviewScore = reviewScore;
        this.category = category;
        this.rating = rating;
    }
}
