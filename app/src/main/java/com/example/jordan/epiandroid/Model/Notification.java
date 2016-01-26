package com.example.jordan.epiandroid.Model;

/**
 * Created by jordan on 26/01/2016.
 */
public class Notification {
    private String urlPicture;
    private String content;
    private String date;

    public Notification(String urlPicture, String content, String date) {
        this.urlPicture = urlPicture;
        this.content = content;
        this.date = date;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
