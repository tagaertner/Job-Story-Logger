package com.jobstories.story.repository;


import com.jobstories.story.model.JobStory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This creates a database helper for JobStory obj
public interface JobStoryRepository extends JpaRepository<JobStory, Long> {

    List<JobStory> findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(String title, String body);

}

