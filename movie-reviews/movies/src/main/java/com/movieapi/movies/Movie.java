package com.movieapi.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") //this class sheet presents each document in the movies' collection(db)
@Data //getters, setters, toStrings
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id //this property should be treated as a unique identifier for each movie in the db
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //causes the db to store only the ids of the reviews, the reviews will be
    //in a separate collection - manual reference relationship
    private List<Review> reviews;
}
