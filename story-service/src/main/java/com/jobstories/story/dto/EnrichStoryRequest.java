// This object moves data in/out of the API
package com.jobstories.story.dto;

public class EnrichStoryRequest {
    private String text;

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}