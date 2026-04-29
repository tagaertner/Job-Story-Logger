package com.jobstories.story.controller;

import com.jobstories.story.service.JobStoryService;
import com.jobstories.story.model.JobStory;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
    @ResponseStatus(HttpStatus.CREATED)
    public JobStory createStory(@Valid @RequestBody JobStory story) {
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


    @PutMapping("/stories/{id}")
    public JobStory updateStory(@PathVariable Long id, @RequestBody JobStory updatedStory){
        return jobStoryService.updateStory(id, updatedStory);
    }

    @GetMapping("/stories/paginated")
    public Page<JobStory> getStoriesPaginated(@RequestParam int page, @RequestParam int size){
        return jobStoryService.getStoriesPaginated(page, size);
    }

    @GetMapping("/stories/search")
    public List<JobStory> searchJobStories(@RequestParam String query){
        return jobStoryService.searchStories(query);
    }

    @GetMapping("/stories/filter")
    public List<JobStory> filterStoriesByDate(@RequestParam LocalDate from, @RequestParam LocalDate to){
        return jobStoryService.filterStoriesByDate((from), to);
    }

    @GetMapping("/stories/mood")
    public List<JobStory> getStoriesByMood(@RequestParam String mood){
        return jobStoryService.getStoriesByMood(mood);
    }

    @GetMapping("/stories/count")
    public long getStoryCount(){
        return jobStoryService.getStoryCount();
    }

    @GetMapping("/stories/oldest")
    public List<JobStory> getStoriesOldestFirst(){
        return jobStoryService.getStoriesOldestFirst();
    }

    @GetMapping("/stories/newest")
    public List<JobStory> getStoriesNewestFirst(){
        return jobStoryService.getStoriesNewestFirst();
    }

    @GetMapping("/stories/usage-history")
    public Map<LocalDate,Long> getUsageHistory(){
        return jobStoryService.getUsageHistory();
    }

     @GetMapping("/stories/{id}")
    public JobStory getStoryById(@PathVariable Long id){
        return jobStoryService.getStoryById(id);
    }
}
