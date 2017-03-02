package com.image.entity;

import java.util.Date;

public class Image {
    private long id;
    private String uri;
    private Date date = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", date=" + date +
                '}';
    }
}
