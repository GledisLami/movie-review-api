package com.movieapi.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.util.Map;

//creating endpoint
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    //1 post method
    //the review will be under the movie page we are currently into, so we can make the request
    @Autowired
    private ReviewService service;

    @PostMapping()
    //whatever we get in the request body we would like to convert it to a map of key/value string
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
        /*
        This endpoint will receive a JSON data from the user and then convert it to a map where
        the keys/values are strings. From this map we will be able to access them.
         */
    }
}
