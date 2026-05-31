package com.jobstories.story.ai;

import org.springframework.stereotype.Service;

@Service
public class MockAiService implements AiService {

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

        if (lowerBody.contains("bug") || lowerBody.contains("debug") || lowerBody.contains("error")) {
            return new AiEnrichment(
                    "Debugging a Backend Issue",
                    "This story describes finding and fixing a technical issue.",
                    "debugging, bug fix, backend",
                    "positive",
                    "Debugging",
                    "debugging, problem solving, backend development",
                    "Use this story to explain how you investigated the issue, found the root cause, and fixed it."
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
        
        if (lowerBody.contains("blocked") || lowerBody.contains("stuck")) {
            return new AiEnrichment(
                "Blocked, But Not Defeated",
                "This story describes getting stuck, identifying a blocker, and working through it instead of rage-quitting into the sunset.",
                "blocker, problem solving, persistence",
                "challenged",
                "Blocker",
                "debugging, communication, persistence",
                "Use this story to explain what blocked you, how you asked for help or investigated, and what you learned."
            );
        }

        if (lowerBody.contains("deploy") || lowerBody.contains("release")) {
            return new AiEnrichment(
                    "Deployment Drama, Handled",
                    "This story describes working through a deployment or release task without letting the server goblins win.",
                    "deployment, release, backend",
                    "positive",
                    "Deployment",
                    "Spring Boot, backend development, release management",
                    "Use this story to explain how you prepared, tested, released, and handled any issues."
            );
        }

        if (lowerBody.contains("mentor") || lowerBody.contains("helped") || lowerBody.contains("explained")) {
            return new AiEnrichment(
                    "Helping Without Hovering",
                    "This story describes helping someone understand a problem without grabbing the keyboard like a gremlin.",
                    "mentoring, communication, support",
                    "positive",
                    "Mentoring",
                    "communication, teaching, collaboration",
                    "Use this story to show how you explained something clearly and helped someone grow."
            );
        }

        if (lowerBody.contains("lead") || lowerBody.contains("owned") || lowerBody.contains("planned")) {
            return new AiEnrichment(
                    "Owning the Chaos",
                    "This story describes taking ownership, planning the work, and keeping the chaos from becoming everyone’s new roommate.",
                    "leadership, ownership, planning",
                    "positive",
                    "Leadership",
                    "ownership, planning, communication",
                    "Use this story to show how you took initiative, organized the work, and moved things forward."
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
}