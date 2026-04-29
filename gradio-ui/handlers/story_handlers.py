from api_client import create_story, delete_story, filter_stories_by_date,get_stories_by_mood, get_all_stories, update_story, get_stories_paginated


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
    

