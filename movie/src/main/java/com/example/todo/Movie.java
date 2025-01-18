package com.example.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="movies")
public class Movie{
    @Id
    private String id;
    private String name;
    private String author;
    public Movie(){

    }
    public Movie(String name,String author){
        this.name=name;
        this.author=author;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
}