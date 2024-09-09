package com.astooltech.advancedview.database.model;

public class ScriptModel {
    public ScriptModel(int id, String content, String url) {
        this.id = id;
        this.content = content;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private int id;
    private String content;
    private String url;
}
