package com.jobstories.story.controller;

import com.jobstories.story.service.JobStoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobstories.story.model.JobStory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
public class JobStoryController {

    private final JobStoryService jobStoryService;

    public JobStoryController(JobStoryService jobStoryService) {
        this.jobStoryService = jobStoryService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Story service is running";
    }

    @PostMapping("/stories")
    public JobStory createStory(@RequestBody JobStory story) {
        return jobStoryService.createStory(story);
}

    @GetMapping("/stories")
    public List<JobStory> getAllStories(){
        return jobStoryService.getAllStories();
    }

    @DeleteMapping("/stories/{id}")
    public void deleteStory(@PathVariable Long id){
        jobStoryService.deleteStory(id);
    }

    @GetMapping("/stories/{id}")
    public JobStory getStoryById(@PathVariable Long id){
        return jobStoryService.getStoryById(id);
    }


}