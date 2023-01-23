package com.movieapi.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    //template -> another way to use the db
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now())); //returns the data you pushed inside
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
        /*
        Look for the movie with the imdbId, we create a new review and associate it with the found movie.
        Now that we have the review obj, we have to insert it to the db.
        We are using the template to perform an update call on the movie class.
        Each movie in our collection contains an empty array of reviews.
        We need to update this array and push a new reviews obj in this.
        So we say movie.class, then we perform the matching. So which movie are you updating?
        We are updating a movie where the imdbId of the movie in the db matches the imdbId
        that we have received from the user. Then we want to apply this update with .apply.
        We create a new update definition which does the job of making the change inside the
        database. We want to update the reviews(update().push) in this found movie
        and the value of this movie will be review.
        The review we created will be pushed inside the array
        .first() to make sure we are getting a single movie and updating that.
         */
    }
}
