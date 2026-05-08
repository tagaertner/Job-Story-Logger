package com.jobstories.story.ai;

public class AiEnrichment{
    private String title;
    private String summary;
    private String tags;
    private String sentiment;
    private String category;
    private String skills;
    private String interviewTip;

    public AiEnrichment(String title,String summary, String tags, String sentiment, String category, String skills, String interviewTip){
        this.title = title;
        this.summary = summary;
        this.tags = tags;
        this.sentiment = sentiment;
        this.category = category;
        this.skills = skills;
        this.interviewTip = interviewTip;
    }


    public String getTitle(){
        return title;
    }

    public String getSummary(){
        return summary;
    }

    public String getTags(){
        return tags;
    }

    public String getSentiment(){
        return sentiment;
    }

    public String getCategory(){
        return category;
    }

    public String getSkills(){
        return skills;
    }

    public String getInterviewTip(){
        return interviewTip;
    }

}