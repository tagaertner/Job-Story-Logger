from interface import build_interface
import os


"""
 Main Gradio application entry point.
 Loads components and assembles the UI   
"""
API_Base_URL = os.getenv("STORY_SERVICE_URL", "http://localhost:8080")

if __name__ == "__main__":
    port = 7860
    demo = build_interface()

    demo.launch(
        server_name="0.0.0.0",
        server_port=port,
    
)
