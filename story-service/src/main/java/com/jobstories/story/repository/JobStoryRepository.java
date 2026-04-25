package com.jobstories.story.repository;


import com.jobstories.story.model.JobStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobStoryRepository extends JpaRepository<JobStory, Long> {

    

}

