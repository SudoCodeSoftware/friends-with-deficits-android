package com.sudo_code.friendswithdeficits;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFriendActivity extends AppCompatActivity {
    private EditText nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameTxt = (EditText) findViewById(R.id.nameText);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addFriend(View view) {
        String name = nameTxt.getText().toString();
        Toast.makeText(AddFriendActivity.this, "Added " + name, Toast.LENGTH_SHORT).show();
        finish();
    }
}
