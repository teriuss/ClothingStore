package com.store.courseworkmain.model;

public class Course {
    int id, category;
    String img,title, brand,cost,color;

    public Course(int id, String img, String title, String brand, String cost, String color,int category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.brand = brand;
        this.cost = cost;
        this.color = color;
        this.category=category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
