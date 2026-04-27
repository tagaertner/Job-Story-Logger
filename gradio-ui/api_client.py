import requests
import os
from datetime import date

API_URL = os.getenv("STORY_API_URL") or "http://localhost:8080"

def create_story(title, body, mood):
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
            
        
            

def getAllStories():
    pass

def deleteStory():
    pass

def getStoryById():
    pass

def updateStory():
    pass

def getStoriesPaginated():
    pass

def searchStories():
    pass

def fileStoriesByDate():
    pass

def getStoriesNewestFirst():
    pass

def getStoriesOldestFirst():
    pass

def getStoriesByMood():
    pass

def getStoryCount():
    pass

def getUsageHistory():
    pass