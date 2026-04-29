package com.jobstories.story.ai;

import org.springframework.stereotype.Service;

@Service
public class MockAiService implements AiService{

    @Override
    public AiEnrichment analyzeStory(String storyText){
        return new AiEnrichment(
            "Mock summary: This story shows progress and reflection.",
            "debugging, learning, backend",
            "positive",
            "Learning",
            "Java, Spring Boot, PostgreSQL",
             "This could be useful for an interview question about problem solving."

        );
        };
    }
