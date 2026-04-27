from api_client import create_story

def handle_create_story(title, body, mood):
    return create_story(title, body, mood)