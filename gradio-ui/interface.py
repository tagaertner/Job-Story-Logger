import gradio as gr
from handlers.story_handlers import handle_create_story

def build_interface():
    with gr.Blocks() as demo:
        gr.Markdown("# Engineering Journal: My Job Story Logger")
        
        with gr.Tab("Add Story"):
            title= gr.Textbox(label="Title")
            body= gr.Textbox(label="Body", lines=5)
            mood = gr.Dropdown(
                choices=["happy", "neutral", "focused", "frustrated", "productive"],
                label="Mood"
            )
        
        
         #  === EVENT HANDLERS === 
        submit_button = gr.Button("Save Story")
        result = gr.Textbox(label="Result")

        submit_button.click(
                fn=handle_create_story,
                inputs=[title, body, mood],
                outputs=result
            )
    
    return demo
            
            