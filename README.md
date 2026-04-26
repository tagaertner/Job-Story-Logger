# Job Story Logger

A backend service for logging daily engineering job stories, including wins, blockers, lessons learned, and mood tracking.

## Current Features

- Create job stories
- View all stories
- View one story by ID
- Update a story
- Delete a story
- PostgreSQL persistence
- Seed data
- Pagination
- Search by title/body
- Filter by date range
- Filter by mood
- Usage count
- Usage history
- 404 handling for missing stories

## Future Error Handling

- Invalid page/size → 400
- Invalid date range → 400
- Empty title/body → 400
- Invalid mood → 400
- Database/server issues → 500
