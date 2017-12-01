package com.kortain.enterprise.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kortain.enterprise.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by satiswardash on 01/12/17.
 */

public class HomeActivityImageRecyclerAdapter extends RecyclerView.Adapter<HomeActivityImageRecyclerAdapter.ViewHolder> {

    Context mContext;
    List<String> mList;
    LayoutInflater mLayoutInflater;

    public HomeActivityImageRecyclerAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.home_recyclerview_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_image_view);
        }

        public void bind(int position) {
            Picasso.with(mContext)
                    .load("file:///android_asset/"+mList.get(position))
                    .fit()
                    .into(imageView);
        }
    }
}
