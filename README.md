# Job Story Logger

A backend service for logging and organizing engineering job stories, including wins, blockers, lessons learned, and mood tracking.

## Work in Progress

The project is being developed incrementally with a focus on backend system design, testing strategy, and AI-assisted story enrichment. The long-term goal is to help engineers organize experiences for performance reviews, behavioral interviews, and career reflection.

## Why This Project Exists

I built this project in Java because I wanted to learn the language, and Spring Boot was a framework I already had a working foundation in from other projects. The goal was to apply a real domain problem, logging and organizing engineering work stories, to a language I was actively building skill in, rather than just working through a tutorial.

## Why Mock AI First

The AI enrichment layer was built with a mock service before any real model integration. The reasoning: start simple on purpose to prove the core flow works, find bugs faster, and understand each layer before adding complexity. `MockAiService` implements the same interface a real model would, so the enrichment pipeline, the service layer, and the tests around it, does not need to change when a real AI backend is swapped in later.

## Current Features

### Story Management

- Create job stories
- View all stories
- View one story by ID
- Update a story
- Delete a story

### Search & Filtering

- Pagination
- Search by title/body
- Filter by date range
- Filter by mood
- Usage count
- Usage history

### AI Enrichment (MVP)

- Mock AI enrichment service
- AI-generated: title, summary, tags, sentiment, category, skills, interview tips
- DTO request handling for `/stories/enrich`

### Persistence

- PostgreSQL persistence
- Seed data

### Testing

- JUnit 5
- Mockito
- Service-layer unit tests
- Edge case testing

### Error Handling

- 404 handling for missing stories

## Planned Improvements

### Validation & Error Handling

- Invalid page/size → 400
- Invalid date range → 400
- Empty title/body → 400
- Invalid mood → 400
- Database/server issues → 500

### AI & Architecture

- Real OpenAI integration
- GraphQL API
- AI-powered tagging/search
- AI persistence for saved enrichments
- LangChain4j exploration

## Architecture

```text
Controller → Service → Repository → Database
AI Flow:
Controller → JobStoryService → MockAiService → AiEnrichment
```

## Tech Stack

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- H2
- JUnit 5
- Mockito

## Running Locally

```bash
mvn spring-boot:run
```
