package com.jobstories.story.service;

import com.jobstories.story.repository.JobStoryRepository;
import org.springframework.stereotype.Service;
import com.jobstories.story.model.JobStory;

@Service
public class JobStoryService {

    private final JobStoryRepository jobStoryRepository;

    public JobStoryService(JobStoryRepository jobStoryRepository) {
        this.jobStoryRepository = jobStoryRepository;
    }

    public JobStory createStory(JobStory story){
        return jobStoryRepository.save(story);
    }
}