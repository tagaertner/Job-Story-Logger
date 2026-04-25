package com.jobstories.story.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Tells JPA/Hibernate this class maps to a database table
@Entity
public class JobStory {

     @Id // Marks this field as the primary key
     // Lets the database auto-gen the ID
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String body;
    private LocalDate date;
    private String mood;

    // Need this no-arg constructor so Spring and the db can create obj automaticaly
    public JobStory(){

    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public Long getId(){
        return id;

   }

   public void setId(Long id){
    this.id = id;
   }

   public String getBody(){
        return body;
   }

   public void setBody(String body){
        this.body = body;
   }

   public LocalDate getDate(){
        return date;
   }

   public void setDate(LocalDate date){
        this.date = date;
   }

   public String getMood(){
        return mood;
   }

   public void setMood(String mood){
        this.mood = mood;
   }
}
