package com.kortain.enterprise;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by satiswardash on 29/11/17.
 */

public class App extends Application {

    public static final String[] categories = {"Italian Pizzas", "French Toasts", "French Desserts", "Biriyani", "Hotdogs", "American Burgers"};
    public static final String[] images = {"https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanners_00008.jpeg?alt=media&token=eef127a4-dad7-4cbc-92e1-9d2a38bda2cd", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00002.jpeg?alt=media&token=bbb3fbee-9340-47ff-b504-746279aaba38", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00003.jpeg?alt=media&token=63fb3208-2244-498a-8c5e-308cc02781ac", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00004.jpeg?alt=media&token=94c3a38c-9b7f-409a-a401-70a614fe27c6", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00005.jpeg?alt=media&token=0916158f-bc87-4213-8fee-a39d0bd4dd00", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00006.jpeg?alt=media&token=0d77c75f-68b2-4c2e-8916-31669e30f133", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00007.jpeg?alt=media&token=c5fb225b-1e23-4a62-9daf-14a34b16c0b8"};
    public static FirebaseAuth mAuth;
    public static FirebaseUser user;

    @Override
    public void onCreate() {
        super.onCreate();

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(this, AuthenticationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return;
        }
    }

}
