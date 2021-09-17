package com.example.retrofit;

public class Posts {

    private int userId, id;
    private  String  title, body;

    public Posts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserID() { return userId; }

    public int getID() { return id; }

    public String getTitle() { return title; }

    public String getBody() { return body; }

}

