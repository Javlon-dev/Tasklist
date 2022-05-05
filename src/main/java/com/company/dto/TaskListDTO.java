package com.company.dto;

public class TaskListDTO {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public TaskListDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TaskListDTO setContent(String content) {
        this.content = content;
        return this;
    }
}
