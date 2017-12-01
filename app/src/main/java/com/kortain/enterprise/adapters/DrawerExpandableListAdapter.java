package com.kortain.enterprise.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.kortain.enterprise.R;
import com.kortain.enterprise.models.DrawerMenuItem;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by satiswardash on 30/11/17.
 */

public class DrawerExpandableListAdapter extends BaseExpandableListAdapter {


    Context mContext;
    ExpandableListView mExpandableListView;
    List<DrawerMenuItem> mMenuItemList;
    HashMap<DrawerMenuItem, List<String>> mItemListMap;

    public DrawerExpandableListAdapter(Context context, ExpandableListView listView, List<DrawerMenuItem> menuItemList, HashMap<DrawerMenuItem, List<String>> drawerMenuItemListHashMap) {
        mContext = context;
        mExpandableListView = listView;
        mMenuItemList = menuItemList;
        mItemListMap = drawerMenuItemListHashMap;
    }

    @Override
    public int getGroupCount() {
        return mMenuItemList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mItemListMap.get(this.mMenuItemList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mMenuItemList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mItemListMap.get(this.mMenuItemList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final DrawerMenuItem menuItem = mMenuItemList.get(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_listview_header, null);
        }

        TextView lblListHeader = convertView.findViewById(R.id.drawer_list_view_header);
        final ImageView headerIcon = convertView.findViewById(R.id.drawer_list_view_image);

        lblListHeader.setText(menuItem.getItemName());

        Picasso.with(mContext)
                .load("file:///android_asset/"+menuItem.getImageId())
                .fit().centerCrop()
                //.resize(32, 32)
                .into(headerIcon);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String child = (String) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_listview_item, null);
        }

        TextView childTextView = convertView.findViewById(R.id.drawer_list_view_item);
        childTextView.setText(child);

        return convertView;
    }
}
