package com.jobstories.story.controller;

import com.jobstories.story.service.JobStoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobstories.story.model.JobStory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}