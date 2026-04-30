package com.jobstories.story;

import com.jobstories.story.ai.MockAiService;
import com.jobstories.story.ai.AiEnrichment;

public class TestAIEnrichment {
    public static void main(String[] args) {
        MockAiService mockAIService = new MockAiService();

        AiEnrichment result = mockAIService.analyzeStory(
    "I fixed a slow database query and reduced load time."
        );  

        System.out.println(result.getTitle());
        System.out.println(result.getCategory());
        System.out.println(result.getTags());
        System.out.println(result.getSkills());
        System.out.println(result.getInterviewTip());
    }
}