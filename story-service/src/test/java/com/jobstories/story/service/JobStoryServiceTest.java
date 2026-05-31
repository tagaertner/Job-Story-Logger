package com.jobstories.story.service;

import com.jobstories.story.ai.AiEnrichment;
import com.jobstories.story.ai.MockAiService;
import com.jobstories.story.repository.JobStoryRepository;
import com.jobstories.story.model.JobStory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class JobStoryServiceTest{

    // Fake dependency
    @Mock
    private JobStoryRepository jobStoryRepository;
    
    private MockAiService mockAiService;

    private JobStoryService jobStoryService;

    @BeforeEach
    void setUp(){
        mockAiService = new MockAiService();

        jobStoryService = new JobStoryService(jobStoryRepository, mockAiService);
    }

    // JobStory CRUD tests

    @Test
    void createStory_shouldSaveAndReturnStory(){
        JobStory story = new JobStory();
        story.setBody("I fixed a slow database query.");

        when(jobStoryRepository.save(story)).thenReturn(story);

        JobStory result = jobStoryService.createStory(story);

        assertThat(result.getBody()).isEqualTo("I fixed a slow database query.");
    }

     @Test
    void createStory_withEmptyBody_shouldThrowException() {
        JobStory story = new JobStory();
        story.setBody(" ");

        assertThatThrownBy(()-> jobStoryService.createStory(story))
            .isInstanceOf(RuntimeException.class);

    }

    @Test
    void createStory_withNullBody_shouldThrowException(){
        // Arrange
        JobStory story = new JobStory();
        story.setBody(null);

        // Act + Assert
        assertThatThrownBy(() -> jobStoryService.createStory(story))
            .isInstanceOf((RuntimeException.class));
    }
   
    @Test
    void getStoryById_withMissingId_shouldThrowException() {
        // Arrange 
        Long id = 99L;

        when(jobStoryRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        assertThatThrownBy(() -> jobStoryService.getStoryById(id))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void updateStory_withMissingId_shouldThrowException() {
        // arrange
        Long id = 99L;

        JobStory updatedStory = new JobStory();
        updatedStory.setBody("Update story body");

        when(jobStoryRepository.findById(id)).thenReturn(Optional.empty());

        // Act + Assert
        assertThatThrownBy(()-> jobStoryService.updateStory(id, updatedStory))
            .isInstanceOf(RuntimeException.class);

    }

    @Test
    void deleteStory_shouldCallRepositoryDeleteById() {
        // Arange
        Long id = 99L;

        // Act
        jobStoryService.deleteStory(id);

        // Assert
        verify(jobStoryRepository).deleteById(id);
    }

   
    @Test
    void searchStories_withNoResults_shouldReturnEmptyList() {
        //Arrange
        String query = "nothing";

        when(jobStoryRepository.findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(query, query))
            .thenReturn(List.of());

        // Act
        List<JobStory> result = jobStoryService.searchStories(query);

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    void filterStoriesByDate_withInvalidDateRange_shouldReturnEmptyList() {
        // Arrange
        LocalDate from = LocalDate.of(2026, 5, 10);
        LocalDate to = LocalDate.of (2026, 5, 1);

        // Act
        List<JobStory> result = jobStoryService.filterStoriesByDate(from, to);

        // Assert
        assertThat(result).isEmpty();
    }

    // AI enrichement tests
    @Test
    void enrichJobStory_shouldReturnAiEnrichment(){
        // arrange 
        String body = "I fixed a slow database query.";

        // act
        AiEnrichment result = jobStoryService.enrichJobStory((body));

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("Database Performance Improvement");
        assertThat(result.getCategory()).isEqualTo("Performance");
    }  

    @Test
    void enrichJobStory_withEmptyBody_shouldThrowException() {
        // Arrange
        String body = "";

        // Act + Assert
        assertThatThrownBy(()-> jobStoryService.enrichJobStory(body))
            .isInstanceOf(RuntimeException.class);

    }
     @Test
    void enrichJobStory_withNullBody_shouldThrowException(){
        // Arrange
        String body = null;

        //Act + Assert
        assertThatThrownBy(()-> jobStoryService.enrichJobStory(body))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void enrichJobStory_shouldReturnDebuggingCategory(){
        // Arrange
        String body = "I debugged a backend error in production";

        // Act
        AiEnrichment result = jobStoryService.enrichJobStory(body);

        // Assert
        assertThat(result.getCategory()).isEqualTo("Debugging");
        assertThat(result.getTitle()).isEqualTo("Debugging a Backend Issue");
    }

    @Test
    void enrichJobStory_shouldReturnCollaborationCategory(){
        // Arrange
        String body = "I paired with another engineer to solve a deployment issue.";

        // Act
        AiEnrichment result = jobStoryService.enrichJobStory(body);

        // Assert
        assertThat(result.getCategory()).isEqualTo("Collaboration");
    }

    @Test
    void enrichJobStory_shouldReturnBlockedCategory(){
        // Arrange
        String body = "I got blocked and then got unblocked, then blocked again";

        //Act
        AiEnrichment result = jobStoryService.enrichJobStory(body);

        //Assert
        assertThat(result.getCategory()).isEqualTo("Blocker");
        assertThat(result.getTitle()).isEqualTo("Blocked, But Not Defeated");
    }

    @Test
    void enrichJobStory_shouldReturnDeployCategory(){
        //Arrange
        String body = "I managed my deploy and relese";

        //Act 
        AiEnrichment result = jobStoryService.enrichJobStory(body);

        //Assert
        assertThat(result.getCategory()).isEqualTo("Deployment");
        assertThat(result.getTags()).contains("backend");
        
    }

    @Test
    void enrichJobStory_shouldReturnMentorCategory(){
        //Arrange
        String body = "Thank God for my mentor";

        //Act 
        AiEnrichment result = jobStoryService.enrichJobStory(body);

        //Assert
        assertThat(result.getCategory()).isEqualTo("Mentoring");
        assertThat(result.getSummary()).contains("helping");
    }

    @Test
    void enrichJobStory_shouldReturnLeadCategory() {
        // Arrange
        String body = "I planned a backend feature and owned the work.";

        // Act
        AiEnrichment result = jobStoryService.enrichJobStory(body);

        // Assert
        assertThat(result.getCategory()).isEqualTo("Leadership");
        assertThat(result.getSkills()).contains("planning");
}

    

}