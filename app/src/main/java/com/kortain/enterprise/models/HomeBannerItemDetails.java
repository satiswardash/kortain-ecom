package com.kortain.enterprise.models;

/**
 * Created by satiswardash on 05/12/17.
 */

public class HomeBannerItemDetails {

    private String id;
    private String title;
    private String description;
    private String uri;
    private String action;

    public HomeBannerItemDetails() {
    }

    public HomeBannerItemDetails(String id, String title, String description, String uri, String action) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.uri = uri;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
