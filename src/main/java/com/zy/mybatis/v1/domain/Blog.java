package com.zy.mybatis.v1.domain;

import java.io.Serializable;

public class Blog implements Serializable {

    private int id;
    private String name;
    private String book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book='" + book + '\'' +
                '}';
    }
}
