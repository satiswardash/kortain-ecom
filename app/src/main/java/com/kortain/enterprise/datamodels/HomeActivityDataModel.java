package com.kortain.enterprise.datamodels;

import com.kortain.enterprise.models.HomeBannerItemDetails;
import com.kortain.enterprise.models.FlashOfferItemDetails;
import com.kortain.enterprise.models.ShowcaseItems;
import com.kortain.enterprise.models.TopCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satiswardash on 05/12/17.
 */

public class HomeActivityDataModel {

    private List<HomeBannerItemDetails> homeBannerItemDetailsList = new ArrayList<>();
    private List<ShowcaseItems> showcaseItemsList = new ArrayList<>();
    private List<FlashOfferItemDetails> flashOfferItemDetailsList = new ArrayList<>();
    private List<TopCategory> topCategoryList = new ArrayList<>();

    public HomeActivityDataModel() {
    }

    public HomeActivityDataModel(List<HomeBannerItemDetails> homeBannerItemDetailsList, List<ShowcaseItems> showcaseItemsList, List<FlashOfferItemDetails> flashOfferItemDetailsList, List<TopCategory> topCategoryList) {
        this.homeBannerItemDetailsList = homeBannerItemDetailsList;
        this.showcaseItemsList = showcaseItemsList;
        this.flashOfferItemDetailsList = flashOfferItemDetailsList;
        this.topCategoryList = topCategoryList;
    }

    public List<HomeBannerItemDetails> getHomeBannerItemDetailsList() {
        return homeBannerItemDetailsList;
    }

    public void setHomeBannerItemDetailsList(List<HomeBannerItemDetails> homeBannerItemDetailsList) {
        this.homeBannerItemDetailsList = homeBannerItemDetailsList;
    }

    public List<ShowcaseItems> getShowcaseItemsList() {
        return showcaseItemsList;
    }

    public void setShowcaseItemsList(List<ShowcaseItems> showcaseItemsList) {
        this.showcaseItemsList = showcaseItemsList;
    }

    public List<FlashOfferItemDetails> getFlashOfferItemDetailsList() {
        return flashOfferItemDetailsList;
    }

    public void setFlashOfferItemDetailsList(List<FlashOfferItemDetails> flashOfferItemDetailsList) {
        this.flashOfferItemDetailsList = flashOfferItemDetailsList;
    }

    public List<TopCategory> getTopCategoryList() {
        return topCategoryList;
    }

    public void setTopCategoryList(List<TopCategory> topCategoryList) {
        this.topCategoryList = topCategoryList;
    }
}
