package com.kortain.enterprise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.kortain.enterprise.adapters.DrawerExpandableListAdapter;
import com.kortain.enterprise.models.DrawerMenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<DrawerMenuItem> listDataHeader;
    HashMap<DrawerMenuItem, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.drawer_list_view);

        prepareListData();
        DrawerExpandableListAdapter adapter =
                new DrawerExpandableListAdapter(this, expandableListView, listDataHeader, listDataChild);

        expandableListView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<DrawerMenuItem>();
        listDataChild = new HashMap<DrawerMenuItem, List<String>>();

        DrawerMenuItem item1 = new DrawerMenuItem();
        item1.setItemName("heading1");
        item1.setImageId(R.drawable.ic_menu_camera);
        listDataHeader.add(item1);

        DrawerMenuItem item2 = new DrawerMenuItem();
        item2.setItemName("heading2");
        item2.setImageId(R.drawable.ic_menu_camera);
        listDataHeader.add(item2);

        DrawerMenuItem item3 = new DrawerMenuItem();
        item3.setItemName("heading3");
        item3.setImageId(R.drawable.ic_menu_camera);
        listDataHeader.add(item3);

        DrawerMenuItem item4 = new DrawerMenuItem();
        item4.setItemName("heading4");
        item4.setImageId(R.drawable.ic_menu_camera);
        listDataHeader.add(item4);

        DrawerMenuItem item5 = new DrawerMenuItem();
        item5.setItemName("heading5");
        item5.setImageId(R.drawable.ic_menu_camera);
        listDataHeader.add(item5);

        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Submenu item 1");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("Submenu item 1");
        heading2.add("Submenu item 2");
        heading2.add("Submenu item 3");

        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading2);
        listDataChild.put(listDataHeader.get(3), heading1);
        listDataChild.put(listDataHeader.get(4), heading1);

    }
}
