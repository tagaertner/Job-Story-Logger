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



import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

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
    @Test
    void createStory_shouldSaveAndReturnStory(){
        JobStory story = new JobStory();
        story.setBody("I fixed a slow database query.");

        when(jobStoryRepository.save(story)).thenReturn(story);

        JobStory result = jobStoryService.createStory(story);

        assertThat(result.getBody()).isEqualTo("I fixed a slow database query.");
    }

    @Test
    void enrichJobStory_shouldReturnAiRnrichment(){
        String body = "I fixed a slow database query.";

        AiEnrichment result = jobStoryService.enrichJobStory((body));

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).contains("Mock");
    }   

}