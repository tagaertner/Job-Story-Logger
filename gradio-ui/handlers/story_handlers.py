from api_client import create_story, delete_story, filter_stories_by_date


def handle_create_story(title, body, mood):
    return create_story(title, body, mood)

def handle_delete_story(story_id):
    return delete_story(story_id)


def handle_filter_stories_by_date(from_date, to_date):
    return filter_stories_by_date(from_date, to_date)

    

