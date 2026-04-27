import requests
import os
import gradio as gr
from datetime import date

API_URL = os.getenv("STORY_API_URL") or "http://localhost:8080"

def api_request(method, path, payload=None, params=None):
    try:
        response = requests.requests(
            method,
            f"{API_URL}{path}",
            json=payload,
            params=params,
            headers={"Content-Type": "application/json"}
        )
        response.rase_for_status()
        return response.json() if response.text else {"message": "Success"}
    
    except Exception as e:
        return{"error": f"❌ API request failed: {e}"}

def create_story(title, body, mood):
    # Mapping the JobStory model field
    payload = {
        "title": title,
        "body": body,
        "mood": mood,
        "date": str(date.today())
    }
    
    try :
        response = requests.post(API_URL, json=payload)
        
        if response.status_code == 201:
            return "✅ Story saved to database successfully!"
        elif response.status_code == 400:
            error_data = response.json()
            return f"❌ Validation Error: {error_data.get('message', 'Check your inputs')}"
        else:
            return f"❌ Server Error: {response.status_code}"

    except Exception as e:
        return f"Could not connenct to Spring backend: {exec}"
            
        
            

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