package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins="http://localhost:5173")
public class MovieController{

    @Autowired
    private MovieService ser;
    @GetMapping 
    public List<Movie> getMovies(){
        return ser.getMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") String id){
        return ser.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return ser.addMovie(movie);
    }
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable("id") String id,@RequestBody Movie movie){
        return ser.updateMovie(id,movie);
    }
   @DeleteMapping("/{id}")
   public void deleteMovie(@PathVariable("id") String id){
    ser.deleteMovie(id);
   }
    
}