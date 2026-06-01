package com.jobstories.story.dto;


public class CreateJobStoryInput{
    private String title;
    private String body;
    private String date;
    private String mood;

    public void setTitle(String title) {
    this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public String getDate(){
        return date;
    }

    public String getMood(){
        return mood;
    }
}