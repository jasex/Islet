package com.entities;

public class Relax {
    private int id;
    private String pic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    public Relax(String pic){
        this.pic=pic;
    }
}
