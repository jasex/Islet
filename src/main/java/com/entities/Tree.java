package com.entities;

public class Tree {
    private int userId;
    private String note;
    private int like;

    public Tree(int userId, String note, int like) {
        this.userId = userId;
        this.note = note;
        this.like = like;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
