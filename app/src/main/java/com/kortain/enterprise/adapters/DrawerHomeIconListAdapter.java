package com.kortain.enterprise.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.kortain.enterprise.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by satiswardash on 06/12/17.
 */

public class DrawerHomeIconListAdapter  extends ArrayAdapter<String>{

    Context mContext;
    String[] values;


    public DrawerHomeIconListAdapter(@NonNull Context context, @NonNull String[] objects) {
        super(context, -1, objects);
        mContext = context;
        values = objects;

        Log.i("images", "DrawerHomeIconListAdapter: "+objects[0]+objects[1]);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rowView = LayoutInflater.from(mContext).inflate(R.layout.activity_main_icon_frame, parent, false);

        ImageView imageView = rowView.findViewById(R.id.icon_frame_image_view);
        Picasso.with(mContext)
                .load("file:///android_asset/"+values[position])
                .fit().centerCrop()
                //.resize(32, 32)
                .into(imageView);

        return rowView;
    }
}
