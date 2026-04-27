from interface import build_interface

"""
 Main Gradio application entry point.
 Loads components and assembles the UI   
"""

if __name__ == "__main__":
    port = 7860
    demo = build_interface()

    demo.launch(
        server_name="0.0.0.0",
        server_port=port,
    
)
