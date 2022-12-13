package com.example.mybatis.entity;

public class Xiaoshuo {
    private Integer id;
    private String xiaoshuo_image;
    private String title;
    private String content;
private  String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXiaoshuo_image() {
        return xiaoshuo_image;
    }

    public void setXiaoshuo_image(String xiaoshuo_image) {
        this.xiaoshuo_image = xiaoshuo_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
