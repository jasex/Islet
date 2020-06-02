package com.entities;

import com.alibaba.fastjson.annotation.JSONField;

public class Tree {
    @JSONField(serialize = false)
    private int id;
    @JSONField(serialize = true)
    private String quote;
    @JSONField(serialize = false)
    private int like;

    public Tree(int id, String quote, int like) {
        this.id = id;
        this.quote = quote;
        this.like = like;
    }
    public Tree(){

    }

    public Tree(String quote){
        this.quote=quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
