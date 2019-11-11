package com.example.bookapplication;

public class book {
    private int id;
    private String Name;
    private String ImgUrl;
    private String pages;
    private String description;
    private Double price;
    private String author;


    public book(){}


    public book(String name, String imgUrl, String pages, String description, Double price, String author, int id) {
        Name = name;
        ImgUrl = imgUrl;
        this.pages = pages;
        this.description = description;
        this.price = price;
        this.author = author;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        Utility.id++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "Name='" + Name + '\'' +
                ", ImgUrl='" + ImgUrl + '\'' +
                ", pages='" + pages + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", id=" + id +
                '}';
    }

}
