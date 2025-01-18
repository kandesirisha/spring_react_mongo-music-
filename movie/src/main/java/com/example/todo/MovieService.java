package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MovieService{
    @Autowired
    private MovieRepository repo;
  public List<Movie> getMovies(){
    return repo.findAll();
  }
  public Movie getMovieById(String id){
    Optional<Movie> op=repo.findById(id);
    return op.orElse(null);
  }
  public Movie addMovie(Movie movie){
    return repo.save(movie);
  }
  public Movie updateMovie(String id,Movie movie){
    movie.setId(id);
    return repo.save(movie);
  }
  public void deleteMovie(String id){
    repo.deleteById(id);
  }
}