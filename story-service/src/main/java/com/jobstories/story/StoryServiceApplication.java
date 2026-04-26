package com.jobstories.story;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jobstories.story.model.JobStory;
import com.jobstories.story.repository.JobStoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class StoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner run(JobStoryRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new JobStory(null, "First story", "Seed data story 1", LocalDate.now(), "happy"));
                repository.save(new JobStory(null, "Second story", "Seed data story 2", LocalDate.now(), "neutral"));

                repository.save(new JobStory(null, "Fixed GraphQL resolver bug", "I found a resolver issue where nested product data was not loading correctly.", LocalDate.now().minusDays(1), "focused"));
                repository.save(new JobStory(null, "Learned Docker Compose networking", "I learned how services communicate through Docker Compose service names instead of localhost.", LocalDate.now().minusDays(2), "happy"));
                repository.save(new JobStory(null, "Blocked by database connection issue", "I got stuck debugging a PostgreSQL connection error caused by the wrong database URL.", LocalDate.now().minusDays(3), "frustrated"));
                repository.save(new JobStory(null, "Improved API error handling", "I added better error messages when a story could not be found by ID.", LocalDate.now().minusDays(4), "confident"));
                repository.save(new JobStory(null, "Tested CRUD endpoints with curl", "I tested POST, GET, PUT, and DELETE routes from the terminal.", LocalDate.now().minusDays(5), "productive"));
            }
        };
    }
}