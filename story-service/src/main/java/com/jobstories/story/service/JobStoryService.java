package com.jobstories.story.service;

import com.jobstories.story.repository.JobStoryRepository;
import org.springframework.stereotype.Service;
import com.jobstories.story.model.JobStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;
import com.jobstories.story.exception.ResourceNotFoundException;

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
            .orElseThrow(() -> new ResourceNotFoundException("Story not found with id: " + id));
        
    }

   public JobStory updateStory(Long id, JobStory updatedStory) {

    JobStory existingStory = getStoryById(id);

    existingStory.setTitle(updatedStory.getTitle());
    existingStory.setBody(updatedStory.getBody());
    existingStory.setDate(updatedStory.getDate());
    existingStory.setMood(updatedStory.getMood());

    return jobStoryRepository
        .save(existingStory);

}

    public Page<JobStory> getStoriesPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return jobStoryRepository
            .findAll(pageable);
    }

    public List<JobStory> searchStories(String query){
        return jobStoryRepository
            .findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(query, query);
    }

    public List<JobStory> fileStoriesByDate(LocalDate from, LocalDate to){
        return jobStoryRepository
            .findByDateBetween(from, to);
    }

    public List<JobStory> getStoriesNewestFirst(){
        return jobStoryRepository.findAllByOrderByDateDesc();
    }

    public List<JobStory> getStoriesOldestFirst(){
        return jobStoryRepository.findAllByOrderByDateAsc();
    }

    public List<JobStory> getStoriesByMood(String mood){
        return jobStoryRepository
            .findByMood(mood);
    }

    public long getStoryCount(){
        return jobStoryRepository  
            .count();
    }

    public Map<LocalDate, Long> getUsageHistory(){
        return jobStoryRepository.findAll()
            .stream()
            .collect(Collectors.groupingBy(
                JobStory::getDate,
                Collectors.counting()
            ));
    }
      
}