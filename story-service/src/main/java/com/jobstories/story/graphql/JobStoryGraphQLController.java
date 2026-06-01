package com.jobstories.story.graphql;

import com.jobstories.story.model.JobStory;
import com.jobstories.story.service.JobStoryService;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jobstories.story.ai.AiEnrichment;
import com.jobstories.story.dto.CreateJobStoryInput;
import com.jobstories.story.dto.UpdateJobStoryInput;
import com.jobstories.story.dto.UsageHistoryItem;

import java.time.LocalDate;
import java.util.List;

@Controller
public class JobStoryGraphQLController{
    private final JobStoryService jobStoryService;

    public JobStoryGraphQLController(JobStoryService jobStoryService){
        this.jobStoryService = jobStoryService;
    }

    @QueryMapping
    public List<JobStory> stories() {
        return jobStoryService.getAllStories();
    }

    @QueryMapping
    public JobStory story(@Argument Long id){
        return jobStoryService.getStoryById(id);
    }

        @QueryMapping
    public List<JobStory> searchStories(@Argument String query) {
        return jobStoryService.searchStories(query);
    }

    @QueryMapping
    public List<JobStory> storiesByMood(@Argument String mood) {
        return jobStoryService.getStoriesByMood(mood);
    }

    @QueryMapping
    public List<JobStory> storiesByDateRange(@Argument String from, @Argument String to) {
        return jobStoryService.filterStoriesByDate(
                LocalDate.parse(from),
                LocalDate.parse(to)
        );
    }

    @QueryMapping
    public List<JobStory> storiesNewestFirst() {
        return jobStoryService.getStoriesNewestFirst();
    }

    @QueryMapping
    public List<JobStory> storiesOldestFirst() {
        return jobStoryService.getStoriesOldestFirst();
    }

    @QueryMapping
    public List<JobStory> storiesPaginated(@Argument int page, @Argument int size) {
        return jobStoryService.getStoriesPaginated(page, size).getContent();
    }

    @QueryMapping
    public List<UsageHistoryItem> usageHistory() {
        return jobStoryService.getUsageHistory()
                .entrySet()
                .stream()
                .map(entry -> new UsageHistoryItem(
                        entry.getKey().toString(),
                        entry.getValue()
                ))
                .toList();
    }
    @QueryMapping
    public Long storyCount() {
        return jobStoryService.getStoryCount();
    }

    @MutationMapping
    public JobStory createStory(@Argument ("input")CreateJobStoryInput input){
        JobStory story = new JobStory();

        story.setTitle(input.getTitle());
        story.setBody(input.getBody());
        story.setDate(LocalDate.parse(input.getDate()));
        story.setMood(input.getMood());

        return jobStoryService.createStory(story);

    }

    @MutationMapping
    public AiEnrichment enrichStory(@Argument String text){
        return jobStoryService.enrichJobStory(text);
    }

    @MutationMapping
    public Boolean deleteStory(@Argument Long id) {
        jobStoryService.deleteStory(id);
        return true;
    }

    @MutationMapping
    public JobStory updateStory(@Argument Long id, @Argument("input") UpdateJobStoryInput input) {
        JobStory updateStory = new JobStory();

        updateStory.setTitle(input.getTitle());
        updateStory.setBody(input.getBody());
        updateStory.setDate(LocalDate.parse(input.getDate()));
        updateStory.setMood(input.getMood());

        return jobStoryService.updateStory(id, updateStory);
    }


   
}