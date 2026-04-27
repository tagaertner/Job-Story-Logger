package com.jobstories.story.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Tells JPA/Hibernate this class maps to a database table
@Entity
public class JobStory {

     @Id // Marks this field as the primary key
     // Lets the database auto-gen the ID
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, message = "Title is too long")
    private String title;

    @NotBlank(message = "Body cannot be empty")
    private String body;

    @NotNull(message = "Date is required")
    private LocalDate date;
    
    private String mood;

    // Need this no-arg constructor so Spring and the db can create obj automaticaly
    public JobStory(){

    }

    public JobStory(Long id, String title, String body, LocalDate date, String mood){
          this.id = id;
          this.title = title;
          this.body = body;
          this.date = date;
          this.mood = mood;
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
