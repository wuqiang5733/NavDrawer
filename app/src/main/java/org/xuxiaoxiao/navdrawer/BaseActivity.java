package org.xuxiaoxiao.navdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by WuQiang on 2017/1/7.
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        findViewById(R.id.navdrawer_inbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,InboxActivity.class));
                finish();
            }
        });

        findViewById(R.id.navdrawer_addressBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,AddressBookActivity.class));
                finish();
            }
        });

        findViewById(R.id.navdrawer_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this,"You are now logged out!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
