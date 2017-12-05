package com.kortain.enterprise.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kortain.enterprise.R;

import java.util.List;

/**
 * Created by satiswardash on 05/12/17.
 */

public class CategoryButtonsRecyclerAdapter extends RecyclerView.Adapter<CategoryButtonsRecyclerAdapter.ViewHolder> {

    Context mContext;
    List<String> mCategories;
    LayoutInflater mLayoutInflater;

    public CategoryButtonsRecyclerAdapter(Context context, List<String> categories) {
        this.mContext = context;
        this.mCategories = categories;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.activity_main_category_section01, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.category_container_button);
        }

        public void bind(int position) {
            button.setText(mCategories.get(position));
        }
    }
}
