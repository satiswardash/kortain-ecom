package com.kortain.enterprise.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.kortain.enterprise.R;
import com.kortain.enterprise.utils.ScreenUtility;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by satiswardash on 01/12/17.
 */

public class BannerPromoImageRecyclerAdapter extends RecyclerView.Adapter<BannerPromoImageRecyclerAdapter.ViewHolder> {

    Activity mContext;
    List<String> mList;
    LayoutInflater mLayoutInflater;

    String[] labels = {"Chinese Burger", "Fungsoo", "Momos", "Delicacy", "Fried Momos", "Chinese Macaroons"};
    String[] images = {"https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Famerican%2Famerican_00001.jpeg?alt=media&token=6fa2ccd5-7c92-42cd-98af-52668b9e3892", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fchinese%2Fchinese_00005.jpeg?alt=media&token=e92ebc81-c698-45b8-86e4-99fa33999d44", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fchinese%2Fchinese_00006.jpeg?alt=media&token=00101fbb-cf5f-499f-9cbe-477b31117963", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fchinese%2Fchinese_00008.jpg?alt=media&token=3da44504-eb80-4342-8143-dcc20673a048", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Ffrench%2Ffrench_00004.jpeg?alt=media&token=afeb1803-04c5-42ab-a86a-9dbbf8069d43","https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Ffrench%2Ffrench_00002.jpg?alt=media&token=2f36baff-ca5a-4639-9e87-dbb56550ee32"};

    public BannerPromoImageRecyclerAdapter(Activity context, List<String> list) {
        this.mContext = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context.getApplicationContext());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.activity_main_promo_section_01, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.section_imageView33);
            button = itemView.findViewById(R.id.promo_section01_image_label);
        }

        public void bind(int position) {
            button.setText(labels[position]);
            Picasso.with(mContext)
                    .load(images[position])
                    .resize((int)ScreenUtility.getInstance(mContext).getWidth(), (int) ((int)ScreenUtility.getInstance(mContext).getHeight()/1.5))
                    .into(imageView);
        }
    }
}
