package com.example.mybatis.entity;

public class Manhua {

    private Integer id;
    private String image_manhua;
    private String title;
    private String content;
    private String address;

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

    public String getImage_manhua() {
        return image_manhua;
    }

    public void setImage_manhua(String image_manhua) {
        this.image_manhua = image_manhua;
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
