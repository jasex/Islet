package com.entities;

public class Tree {
    private int id;
    private String note;
    private int like;

    public Tree(int id, String note, int like) {
        this.id = id;
        this.note = note;
        this.like = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
