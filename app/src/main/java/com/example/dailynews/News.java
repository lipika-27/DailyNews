package com.example.dailynews;

public class News {
    String title,author,url,imgurl;

    public News() {
    }

    public News(String title, String author, String url, String imgurl) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.imgurl = imgurl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
