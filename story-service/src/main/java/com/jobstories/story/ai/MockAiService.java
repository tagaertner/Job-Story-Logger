package com.jobstories.story.ai;

import org.springframework.stereotype.Service;

@Service
public class MockAiService implements AiService{

@Override
public AiEnrichment analyzeStory(String body) {
    if (body == null || body.isBlank()) {
        throw new RuntimeException("Story body cannot be empty");
    }

    String lowerBody = body.toLowerCase();

    if (lowerBody.contains("database") || lowerBody.contains("query")) {
        return new AiEnrichment(
                "Database Performance Improvement",
                "This story describes improving database performance.",
                "database, query, performance",
                "positive",
                "Performance",
                "Java, Spring Boot, PostgreSQL, debugging",
                "Use this story to explain how you identified a performance issue and improved system behavior."
        );
    }

    if (lowerBody.contains("bug") || lowerBody.contains("debug")) {
        return new AiEnrichment(
                "Debugging a Backend Issue",
                "This story describes finding and fixing a bug.",
                "debugging, bug fix, backend",
                "positive",
                "Debugging",
                "problem solving, debugging, backend development",
                "Use this story to explain how you investigated the issue and found the root cause."
        );
    }

    if (lowerBody.contains("team") || lowerBody.contains("pair")) {
        return new AiEnrichment(
                "Collaborating to Solve a Problem",
                "This story describes collaboration with others.",
                "teamwork, collaboration, communication",
                "positive",
                "Collaboration",
                "communication, teamwork, problem solving",
                "Use this story to show how you worked with others to reach a solution."
        );
    }

    return new AiEnrichment(
            "Engineering Learning Story",
            "This story shows progress, reflection, and learning.",
            "learning, backend, growth",
            "positive",
            "Learning",
            "Java, Spring Boot, backend development",
            "Use this story to explain what you learned and how you applied it."
    );
}
   
        };
    
