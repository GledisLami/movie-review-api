package com.movieapi.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //db access methods
    //we need a reference of the repository
    @Autowired
    private MovieRepository repository; //we need to initialize it with a constructor or with @

    /*
    Uses the repositoy class and talks to the db, gets the list of the movies, and returns it in a list
    to the api layer


     */
    public List<Movie> findAllMovies(){
        //System.out.println(movieRepository.findAll().toString());
        return repository.findAll(); //described inside the mongorepository class, returns
                                          //the datatype on the class, movie
    }

    public Optional<Movie> findMovieByImdbId(String imdbId){
        return repository.findMovieByImdbId(imdbId);
    }
    /* we use Optional<Movie> instead of Movie because we want to let java know that the movie returned
    may be null */
}
