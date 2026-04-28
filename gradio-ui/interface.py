import gradio as gr
from handlers.story_handlers import (
    handle_create_story,
    handle_delete_story,
    handle_filter_stories_by_date,
)

def build_interface():
    with gr.Blocks() as demo:
        gr.Markdown("# Engineering Journal: My Job Story Logger")

        with gr.Tab("Add Story"):
            title = gr.Textbox(label="Title")
            body = gr.Textbox(label="Body", lines=5)
            mood = gr.Dropdown(
                choices=["happy", "neutral", "focused", "frustrated", "productive"],
                label="Mood"
            )
            submit_button = gr.Button("Save Story")
            result = gr.Textbox(label="Result")

        with gr.Tab("Delete Story"):
            story_id = gr.Number(label="Story ID")
            delete_button = gr.Button("Delete Story")
            delete_result = gr.Textbox(label="Result")

        with gr.Tab("Filter by Date"):
            from_date = gr.Textbox(label="From Date (YYYY-MM-DD)")
            to_date = gr.Textbox(label="To Date (YYYY-MM-DD)")
            filter_button = gr.Button("Filter Stories")
            filter_output = gr.JSON(label="Results")

        # Event handlers can go at the bottom
        submit_button.click(
            fn=handle_create_story,
            inputs=[title, body, mood],
            outputs=result
        )

        delete_button.click(
            fn=handle_delete_story,
            inputs=story_id,
            outputs=delete_result
        )

        filter_button.click(
            fn=handle_filter_stories_by_date,
            inputs=[from_date, to_date],
            outputs=filter_output
        )

    return demo