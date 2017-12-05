package com.kortain.enterprise;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.kortain.enterprise.adapters.DrawerExpandableListAdapter;
import com.kortain.enterprise.adapters.HomeActivityImageRecyclerAdapter;
import com.kortain.enterprise.models.DrawerMenuItem;
import com.kortain.enterprise.utils.BadgeDrawable;
import com.kortain.enterprise.utils.ScreenSize;
import com.kortain.enterprise.utils.ScreenUtility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<DrawerMenuItem> listDataHeader;
    HashMap<DrawerMenuItem, List<String>> listDataChild;
    public static final String[] images = {"https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanners_00008.jpeg?alt=media&token=eef127a4-dad7-4cbc-92e1-9d2a38bda2cd", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00002.jpeg?alt=media&token=bbb3fbee-9340-47ff-b504-746279aaba38", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00003.jpeg?alt=media&token=63fb3208-2244-498a-8c5e-308cc02781ac", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00004.jpeg?alt=media&token=94c3a38c-9b7f-409a-a401-70a614fe27c6", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00005.jpeg?alt=media&token=0916158f-bc87-4213-8fee-a39d0bd4dd00", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00006.jpeg?alt=media&token=0d77c75f-68b2-4c2e-8916-31669e30f133", "https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fbanners%2Fbanner_00007.jpeg?alt=media&token=c5fb225b-1e23-4a62-9daf-14a34b16c0b8"};

    private MainActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        prepareListData();
        ExpandableListView listView = findViewById(R.id.drawer_list_view);
        DrawerExpandableListAdapter adapter =
                new DrawerExpandableListAdapter(this, listView, listDataHeader, listDataChild);

        listView.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.recycler_vew_container);
        RecyclerView recyclerView1 = findViewById(R.id.recycler_vew_container1);
        RecyclerView recyclerView2 = findViewById(R.id.recycler_vew_container2);


        HomeActivityImageRecyclerAdapter recyclerAdapter =
                new HomeActivityImageRecyclerAdapter(this, Arrays.asList(images));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerAdapter);

        HomeActivityImageRecyclerAdapter recyclerAdapter1 =
                new HomeActivityImageRecyclerAdapter(this, Arrays.asList(images));
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerAdapter1);

        HomeActivityImageRecyclerAdapter recyclerAdapter2 =
                new HomeActivityImageRecyclerAdapter(this, Arrays.asList(images));

        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerAdapter2);



        mSectionsPagerAdapter = new MainActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        Log.i("screensize", "onCreate: height");
        Log.i("screensize", "onCreate: width");
        mViewPager.getLayoutParams().height = (int) (ScreenUtility.getInstance(this).getHeight()/2.5);
        mViewPager.getLayoutParams().width= (int) ScreenUtility.getInstance(this).getWidth();

        if(ScreenUtility.getInstance(this).getDensity() < 2){
            mViewPager.setPadding(6, 0, 6, 0);
            mViewPager.setPageMargin(-14);
            Toast.makeText(this, ScreenUtility.getInstance(this).getDensity()+"", Toast.LENGTH_SHORT).show();
        }
        else if(ScreenUtility.getInstance(this).getDensity() >= 2 && ScreenUtility.getInstance(this).getDensity() < 3){
            mViewPager.setPadding(10, 0, 10, 0);
            mViewPager.setPageMargin(-35);
            Toast.makeText(this, ScreenUtility.getInstance(this).getDensity()+"", Toast.LENGTH_SHORT).show();
        }
        else if(ScreenUtility.getInstance(this).getDensity() >= 3){
            mViewPager.setPadding(10, 0, 10, 0);
            mViewPager.setPageMargin(-45);
            Toast.makeText(this, ScreenUtility.getInstance(this).getDensity()+"", Toast.LENGTH_SHORT).show();
        }

        mViewPager.setClipToPadding(false);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        ImageView iv1 = findViewById(R.id.imageView441);
        ImageView iv2 = findViewById(R.id.imageView442);

        Picasso.with(this).load("https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Famerican%2Famerican_00006.jpeg?alt=media&token=f04051d3-ca12-49e6-8419-4226c94be274")

                .into(iv1);
        Picasso.with(this).load("https://firebasestorage.googleapis.com/v0/b/kortain-ecommerce-application.appspot.com/o/images%2Fitalian%2Fitalian_00005.jpg?alt=media&token=029b6035-5c89-4580-aaf4-5e3fd1d63242")

                .into(iv2);

    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem itemCart = menu.findItem(R.id.action_notification);
        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
        setBadgeCount(this, icon, "9");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notification) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<DrawerMenuItem>();
        listDataChild = new HashMap<DrawerMenuItem, List<String>>();

        DrawerMenuItem item1 = new DrawerMenuItem();
        item1.setItemName("American");
        item1.setImageId("american.png");
        listDataHeader.add(item1);

        DrawerMenuItem item2 = new DrawerMenuItem();
        item2.setItemName("Chinese");
        item2.setImageId("china.png");
        listDataHeader.add(item2);

        DrawerMenuItem item3 = new DrawerMenuItem();
        item3.setItemName("French");
        item3.setImageId("france.png");
        listDataHeader.add(item3);

        DrawerMenuItem item4 = new DrawerMenuItem();
        item4.setItemName("Indian");
        item4.setImageId("india.png");
        listDataHeader.add(item4);

        DrawerMenuItem item5 = new DrawerMenuItem();
        item5.setItemName("Italian");
        item5.setImageId("italy.png");
        listDataHeader.add(item5);

        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Burgers");
        heading1.add("Hotdogs");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("Noodles");
        heading2.add("Momos");

        List<String> heading3 = new ArrayList<String>();
        heading3.add("Burgers");
        heading3.add("Toasts");
        heading3.add("Sandwich");

        List<String> heading4 = new ArrayList<String>();
        heading4.add("Panjabi");
        heading4.add("Bengoli");
        heading4.add("South Indian");

        List<String> heading5 = new ArrayList<String>();
        heading5.add("Pizzas");
        heading5.add("Pastas");


        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
        listDataChild.put(listDataHeader.get(3), heading4);
        listDataChild.put(listDataHeader.get(4), heading5);

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MainActivity.PlaceholderFragment newInstance(int sectionNumber) {
            MainActivity.PlaceholderFragment fragment = new PlaceholderFragment();
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



            View rootView = inflater.inflate(R.layout.fragment_image_view_pager, container, false);
            ImageView imageView = rootView.findViewById(R.id.section_imageView2);
            Picasso.with(getContext()).load(images[position-1])
                    .resize((int) ScreenUtility.getInstance(getActivity()).getWidth(), (int) ((int) ScreenUtility.getInstance(getActivity()).getHeight()/2.5))
                    .into(imageView);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return MainActivity.PlaceholderFragment.newInstance(position+1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return images.length;
        }


    }

}
