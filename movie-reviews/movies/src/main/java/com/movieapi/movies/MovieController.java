package com.movieapi.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*a layer of the api, concerns itself with the task of getting a request from the user and returning a response
uses a service class and delegates the task of fetching all the movies from the db and giving it back to the api layer
it calls the allMovies method inside the service, gets the list of the movies and returns them with http status ok
it doesn't know what is going on inside the service class



 */
@RestController
@RequestMapping("/api/v1/movies") //any request here will be handled by this controller
public class MovieController {
    @Autowired
    private MovieService service;//reference to our service class

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    } //this instead of String, return string because rest api's should return a proper status
      //and with this it returns status 200, see on PowerShell curl -i http://8080/...

    @GetMapping("/{imdbId}") //search a movie by id, specific path mapping
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        /*@ : lets the framework know that we will be passing the information we got in the mapping as a
        path variable, or we will be using the information passed in the path variable ObjectID
        whatever we are getting through this path var("/{id}"), we want to convert that to an
        ObjectID called id
         */
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);

    }
}
