package com.movieapi.movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


/*
Data access layer of the api. Does the job of actually talking to the db and getting the data back

 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //we let it know what data we are dealing with and what id on the <>
    Optional<Movie> findMovieByImdbId(String imdbId);
    /*
    Just by giving it the imdbId parameter, Spring Data MongoDB will understand what we are trying to do
     */
}

//comes with methods for searching id, not for searching inner data(property names), we implement it
