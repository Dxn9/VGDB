package models;

import lombok.Data;

@Data
public class VideoGame {
    private int id;
    private String name;
    private String releaseDate;
    private String reviewScore;
    private String category;
    private String rating;
}
