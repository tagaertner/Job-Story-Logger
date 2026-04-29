import requests
import os
from datetime import date

API_URL = os.getenv("STORY_API_URL") or "http://localhost:8080"

def api_request(method, path, payload=None,params=None):
    try:
        response = requests.request(
            method=method,
            url=f"{API_URL}{path}",
            json=payload,
            params=params,
            headers={"Content-Type": "application/json"},
        )
        
        response.raise_for_status()
        
        if response.text:
            return response.json()
        
        return {"message": "Success"}
    
    except requests.exceptions.RequestException as e:
        return {"error": f"❌ API request failed: {e}"}

def create_story(title, body, mood):
    if len(body) > 5000:
        return "❌ Story body is too long. Please keep it under 5,000 characters."
    # Mapping the JobStory model field
    payload = {
        "title": title,
        "body": body,
        "mood": mood,
        "date": str(date.today())
    }
    
    try:

        response = requests.post(f"{API_URL}/stories", json=payload)
        response.raise_for_status()

        saved_story = response.json()
        return f"✅ Story saved with id: {saved_story['id']}"

    except requests.exceptions.RequestException as e:

        return f"❌ Could not connect to Spring backend: {e}"
 
        
def get_all_stories():

    try:
        response = requests.get(f"{API_URL}/stories")
        
        response.raise_for_status()
        stories = response.json()
        
        if not stories:
                return f"❌ No stories found"
        return stories
            
    except requests.exceptions.RequestException as e:
        return {"error": f"❌ Could not get stories: {e}"}
    

def delete_story(story_id):
    try:
        response = requests.delete(f"{API_URL}/stories/{story_id}")
        response.raise_for_status()
        
        return "✅ Story deleted successfully"
    
    except requests.exceptions.RequestException as e:
        return {"error": f"❌ could not delete story: {e}"}
    
    
def filter_stories_by_date(from_date, to_date): 
    try:
        params ={
            "from": from_date,
            "to": to_date
        }
        
        response = requests.get(f"{API_URL}/stories/filter", params=params)
        response.raise_for_status()
        
        return response.json()

    except requests.exceptions.RequestException as e:
        return {"error": f"❌ Could not filter stories by date: {e}"}


def get_stories_by_mood(mood):
    try:
        params = {
            "mood":mood
            
        }
        
        response = requests.get(f"{API_URL}/stories/mood", params=params)
        response.raise_for_status()
        
        return response.json()
        
    except requests.exceptions.RequestException as e:
        return {"error": f"❌ Could not get stories by mood: {e}"}

    

def update_story(story_id, title, body, mood):
    payload = {
        "title": title,
        "body": body,
        "mood": mood,
        "date": str(date.today())
    }
    
    try:
        response = requests.put(f"{API_URL}/stories/{int(story_id)}", json=payload)
        response.raise_for_status()

        return response.json()

    except requests.exceptions.RequestException as e:
        return {"error": f"❌ Could not update story: {e}"}


def get_stories_paginated(page, size):
    
    try:
        page = max(0, int(page))
        # size = max(1,int(size))
        
        params = {
            "page":int(page),
            "size":int(size)
        }
        
        response = requests.get(f"{API_URL}/stories/paginated", params=params)
        response.raise_for_status()
        
        return response.json()
    except requests.exceptions.RequestException as e:
         return {"error": f"❌ Could not get paginated stories: {e}"}


def get_stories_newest_first():
    pass

def get_stories_oldest_first():
    pass

def get_story_count():
    pass

def get_usage_history():
    pass

def get_search_job_stories():
    pass