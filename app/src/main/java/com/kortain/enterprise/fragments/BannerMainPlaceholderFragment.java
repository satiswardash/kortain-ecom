package com.kortain.enterprise.fragments;

/**
 * Created by satiswardash on 05/12/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kortain.enterprise.App;
import com.kortain.enterprise.MainActivity;
import com.kortain.enterprise.R;
import com.kortain.enterprise.models.HomeBannerItemDetails;
import com.kortain.enterprise.utils.ScreenUtility;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class BannerMainPlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private static final String ARG_SECTION_NUMBER = "section_number";

    public BannerMainPlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BannerMainPlaceholderFragment newInstance(int sectionNumber) {
        BannerMainPlaceholderFragment fragment = new BannerMainPlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Log.i("ViewPagerInflate", "onCreateView: "+getArguments().getInt(ARG_SECTION_NUMBER));

        int position = getArguments().getInt(ARG_SECTION_NUMBER);
        HomeBannerItemDetails banner = MainActivity.dataModel.getHomeBannerItemDetailsList().get(position-1);



        View rootView = inflater.inflate(R.layout.banners_main_fragment_pager, container, false);

        TextView textView = rootView.findViewById(R.id.banner_title_text);
        textView.setText(banner.getTitle());

        Button button = rootView.findViewById(R.id.banner_action_text);
        button.setText(banner.getAction());

        ImageView imageView = rootView.findViewById(R.id.section_imageView2);
        Picasso.with(getContext()).load(banner.getUri())
                .resize((int) ScreenUtility.getInstance(getActivity()).getWidth(), (int) ((int) ScreenUtility.getInstance(getActivity()).getHeight()/2.5))
                .into(imageView);
        return rootView;
    }
}
