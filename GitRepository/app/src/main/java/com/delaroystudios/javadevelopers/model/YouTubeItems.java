package com.delaroystudios.javadevelopers.model;

/**
 * Created by asus on 15.03.2018.
 */

public class YouTubeItems {

    String title;
    String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YouTubeItems(String title, String id) {

        this.title = title;
        this.id = id;
    }
}
