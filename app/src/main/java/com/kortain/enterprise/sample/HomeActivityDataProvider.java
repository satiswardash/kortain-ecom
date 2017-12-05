package com.kortain.enterprise.sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kortain.enterprise.datamodels.HomeActivityDataModel;
import com.kortain.enterprise.models.FlashOfferItemDetails;
import com.kortain.enterprise.models.HomeBannerItemDetails;
import com.kortain.enterprise.models.ShowcaseItemDetails;
import com.kortain.enterprise.models.ShowcaseItems;
import com.kortain.enterprise.models.TopCategory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by satiswardash on 05/12/17.
 */

public class HomeActivityDataProvider {

    public static HomeActivityDataModel dataModel;

    static {

        dataModel = new HomeActivityDataModel();

        List<HomeBannerItemDetails> banners = new ArrayList<>();
        banners.add(new HomeBannerItemDetails("id 1", "title", "description", "uri", "action"));
        banners.add(new HomeBannerItemDetails("id 2", "title", "description", "uri", "action"));
        banners.add(new HomeBannerItemDetails("id 3", "title", "description", "uri", "action"));
        dataModel.setHomeBannerItemDetailsList(banners);


        List<ShowcaseItemDetails> showcaseItemDetails = new ArrayList<>();
        showcaseItemDetails.add(new ShowcaseItemDetails("id 1", "title", "description", "uri"));
        showcaseItemDetails.add(new ShowcaseItemDetails("id 2", "title", "description", "uri"));
        List<ShowcaseItems> showcaseItems = new ArrayList<>();
        showcaseItems.add(new ShowcaseItems("title", showcaseItemDetails));
        dataModel.setShowcaseItemsList(showcaseItems);


        List<FlashOfferItemDetails> flashOfferItems = new ArrayList<>();
        flashOfferItems.add(new FlashOfferItemDetails("id 1", "title", "description", "uri"));
        flashOfferItems.add(new FlashOfferItemDetails("id 2", "title", "description", "uri"));
        dataModel.setFlashOfferItemDetailsList(flashOfferItems);

        List<TopCategory> topCategories = new ArrayList<>();
        topCategories.add(new TopCategory("id 1", "title"));
        topCategories.add(new TopCategory("id 2", "title"));
        topCategories.add(new TopCategory("id 3", "title"));
        topCategories.add(new TopCategory("id 4", "title"));
        dataModel.setTopCategoryList(topCategories);
    }

    public static String getJsonData(){

        Gson gson = new Gson();
        Type type = new TypeToken<HomeActivityDataModel>(){}.getType();

        return gson.toJson(dataModel, type);
    }
}
