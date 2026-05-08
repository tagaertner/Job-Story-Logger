# Job Story Logger

A backend service for logging and organizing engineering job stories, including wins, blockers, lessons learned, and mood tracking.

## ⚠️ Work in Progress

The project is being developed incrementally with a focus on backend system design, testing strategy, and AI-assisted story enrichment. The long-term goal is to help engineers organize experiences for performance reviews, behavioral interviews, and career reflection.

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
- AI-generated:
  - title
  - summary
  - tags
  - sentiment
  - category
  - skills
  - interview tips
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

mvn spring-boot:run
