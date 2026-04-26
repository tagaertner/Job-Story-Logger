package com.jobstories.story.repository;


import com.jobstories.story.model.JobStory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

// This creates a database helper for JobStory obj
public interface JobStoryRepository extends JpaRepository<JobStory, Long> {

    List<JobStory> findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(String title, String body);
    List<JobStory> findByDateBetween(LocalDate from, LocalDate to);
    List<JobStory> findAllByOrderByDateDesc();

}

