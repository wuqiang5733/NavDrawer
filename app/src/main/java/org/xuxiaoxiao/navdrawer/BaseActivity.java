package org.xuxiaoxiao.navdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

/**
 * Created by WuQiang on 2017/1/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    /*
    * 把 include_nav_drawer.xml 当中的 android:layout_gravity="start" 换成 end
    * 把这个 Activity 当中的 LEFT 换成 RIGHT ，可以从右边滑出来
    */

    private DrawerLayout drawerLayout;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.include_toolbar);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.LEFT))
                    drawerLayout.closeDrawer(Gravity.LEFT);
                else
                    drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        findViewById(R.id.navdrawer_inbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, InboxActivity.class));
                finish();
                drawerLayout.closeDrawer(Gravity.LEFT);

            }
        });

        findViewById(R.id.navdrawer_addressBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, AddressBookActivity.class));
                finish();
                drawerLayout.closeDrawer(Gravity.LEFT);

            }
        });

        findViewById(R.id.navdrawer_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this, "You are now logged out!", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT);

            }
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            private boolean shouldInvalidateOptionsMenu;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                shouldInvalidateOptionsMenu = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                shouldInvalidateOptionsMenu = true;

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                if (newState == DrawerLayout.STATE_IDLE && shouldInvalidateOptionsMenu) {
                    invalidateOptionsMenu();
                    shouldInvalidateOptionsMenu = false;
                }
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.drawer_layout,!drawerLayout.isDrawerOpen(Gravity.LEFT));
        return super.onPrepareOptionsMenu(menu);

    }
}
