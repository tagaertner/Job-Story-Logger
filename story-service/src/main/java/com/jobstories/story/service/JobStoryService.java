package com.jobstories.story.service;

import com.jobstories.story.repository.JobStoryRepository;
import org.springframework.stereotype.Service;
import com.jobstories.story.model.JobStory;

import java.util.List;

@Service
public class JobStoryService {

    private final JobStoryRepository jobStoryRepository;

    public JobStoryService(JobStoryRepository jobStoryRepository) {
        this.jobStoryRepository = jobStoryRepository;
    }

    public JobStory createStory(JobStory story){
        return jobStoryRepository.save(story);
    }

    public List<JobStory> getAllStories(){
        return jobStoryRepository.findAll();
    }

    public void deleteStory(Long id){
        jobStoryRepository.deleteById(id);
    }

    public JobStory getStoryById(Long id){
        return jobStoryRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Story not found"));
        
    }
}