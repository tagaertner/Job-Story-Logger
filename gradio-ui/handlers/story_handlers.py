from api_client import create_story,delete_story, filter_stories_by_date,get_stories_by_mood, get_all_stories, update_story, get_stories_paginated, get_stories_newest_first,get_stories_oldest_first, get_story_count, get_usage_history, search_job_stories
def handle_create_story(title, body, mood):
    return create_story(title, body, mood)

def handle_delete_story(story_id):
    return delete_story(story_id)

def handle_get_all_stories():
    return get_all_stories()
    

def handle_filter_stories_by_date(from_date, to_date):
    return filter_stories_by_date(from_date, to_date)

def handle_get_stories_by_mood(mood):
    return get_stories_by_mood(mood)

def handle_update_story(story_id, title, body, mood):
    return update_story(story_id, title, body, mood)
    
def handle_get_stories_paginated(page, size):
    return get_stories_paginated(page, size)
    
def handle_get_stories_newest_first():
    return get_stories_newest_first()

def handle_get_stories_oldest_first():
    return get_stories_oldest_first()

def handle_get_story_count():
    return get_story_count()

def handle_get_usage_history():
    return get_usage_history()

def handle_search_job_stories(query):
    return search_job_stories(query)
