package com.jobstories.story.dto;

public class UsageHistoryItem {
    private String date;
    private Long count;

    public UsageHistoryItem(String date, Long count) {
        this.date = date;
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public Long getCount() {
        return count;
    }
}