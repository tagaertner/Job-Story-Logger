import gradio as gr
from handlers.story_handlers import (
    handle_create_story,
    handle_delete_story,
    handle_filter_stories_by_date,
    handle_get_stories_by_mood,
    handle_get_all_stories,
    handle_update_story,
    handle_get_stories_paginated
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

        with gr.Tab("Browse Stories"):
            load_button = gr.Button("View All Stories")
            all_stories_output = gr.JSON(label="All Stories")

            gr.Markdown("### Filter by Date")
            from_date = gr.Textbox(label="From Date (YYYY-MM-DD)")
            to_date = gr.Textbox(label="To Date (YYYY-MM-DD)")
            filter_date_button = gr.Button("Filter by Date")
            date_results = gr.JSON(label="Date Results")

            gr.Markdown("### Filter by Mood")
            mood_filter = gr.Dropdown(
                choices=["happy", "neutral", "focused", "frustrated", "productive"],
                label="Mood"
            )
            filter_mood_button = gr.Button("Filter by Mood")
            mood_results = gr.JSON(label="Mood Results")
            
            gr.Markdown("### Paginated Stories")
            page = gr.Number(label="Page", value=0, minimum=0, precision=0)
            size = gr.Number(label="Size", value=5, minimum=0, precision=0)

            pagination_button = gr.Button("Load Page")
            pagination_output = gr.JSON(label="Paginated Results")

        with gr.Tab("Update Story"):
            update_id = gr.Number(label="Story ID")
            update_title = gr.Textbox(label="New Title")
            update_body = gr.Textbox(label="New Body", lines=5)
            update_mood = gr.Dropdown(
                choices=["happy", "neutral", "focused", "frustrated", "productive"],
                label="New Mood"
            )

            update_button = gr.Button("Update Story")
            update_result = gr.JSON(label="Updated Story")
        
        with gr.Tab("Delete Story"):
            story_id = gr.Number(label="Story ID")
            delete_button = gr.Button("Delete Story")
            delete_result = gr.Textbox(label="Result")

        submit_button.click(
            fn=handle_create_story,
            inputs=[title, body, mood],
            outputs=result
        )

        load_button.click(
            fn=handle_get_all_stories,
            outputs=all_stories_output
        )

        filter_date_button.click(
            fn=handle_filter_stories_by_date,
            inputs=[from_date, to_date],
            outputs=date_results
        )

        filter_mood_button.click(
            fn=handle_get_stories_by_mood,
            inputs=mood_filter,
            outputs=mood_results
        )
        update_button.click(
            fn=handle_update_story,
            inputs=[update_id, update_title, update_body, update_mood],
            outputs=update_result
        )

        delete_button.click(
            fn=handle_delete_story,
            inputs=story_id,
            outputs=delete_result
        )
        pagination_button.click(
            fn=handle_get_stories_paginated,
            inputs=[page, size],
            outputs=pagination_output
        )

    return demo