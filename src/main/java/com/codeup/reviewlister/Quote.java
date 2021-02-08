package com.codeup.reviewlister;

public class Quote {

    private String quote;
    private String author;
    private long id;
    private long stars;


    public Quote(long id, String quote, String author, long stars) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.stars = stars;
    }

    public Quote(String quote, String author, long stars) {
        this.quote = quote;
        this.author = author;
        this.stars = stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public long getStars() {
        return stars;
    }

    public String getQuote() {
        return quote;
    }


    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
