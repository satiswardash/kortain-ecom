package com.kortain.enterprise;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import com.kortain.enterprise.adapters.DrawerExpandableListAdapter;
import com.kortain.enterprise.adapters.HomeActivityImageRecyclerAdapter;
import com.kortain.enterprise.models.DrawerMenuItem;
import com.kortain.enterprise.utils.BadgeDrawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<DrawerMenuItem> listDataHeader;
    HashMap<DrawerMenuItem, List<String>> listDataChild;
    String[] images = {"american.png", "india.png", "china.png", "france.png", "italy.png"};

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

        RecyclerView recyclerView = findViewById(R.id.navigation_home_recyclerview);
        HomeActivityImageRecyclerAdapter recyclerAdapter =
                new HomeActivityImageRecyclerAdapter(this, Arrays.asList(images));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerAdapter);
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

}
