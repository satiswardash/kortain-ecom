package com.kortain.enterprise.models;

import java.util.List;

/**
 * Created by satiswardash on 05/12/17.
 */

public class ShowcaseItems {

    private String title;
    private List<ShowcaseItemDetails> showcaseItemDetails;

    public ShowcaseItems() {
    }

    public ShowcaseItems(String title, List<ShowcaseItemDetails> showcaseItemDetails) {
        this.title = title;
        this.showcaseItemDetails = showcaseItemDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ShowcaseItemDetails> getShowcaseItemDetails() {
        return showcaseItemDetails;
    }

    public void setShowcaseItemDetails(List<ShowcaseItemDetails> showcaseItemDetails) {
        this.showcaseItemDetails = showcaseItemDetails;
    }
}
