package com.sudo_code.friendswithdeficits;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FWDActivity extends AppCompatActivity {
    FWD fwd;
    ListView friendsLv;
    ArrayAdapter<Friend> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        friendsLv = (ListView) findViewById(R.id.friendsLv);

        if (fwd == null) {
            fwd = new FWD();
            fwd.addFriend("Max");
        }

        arrayAdapter = new ArrayAdapter<Friend>(this,
                android.R.layout.simple_list_item_1,
                fwd.getFriends());

        friendsLv.setAdapter(arrayAdapter);

        friendsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FWDActivity.this, FriendActivity.class);
                Friend friend = fwd.getFriends().get(i);
                //intent.putExtra("FRIEND", friend);

                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addFriendActivity = new Intent(FWDActivity.this, AddFriendActivity.class);
                startActivityForResult(addFriendActivity, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fwd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handles action bar selections
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;

            case R.id.action_meh:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("NEW_FRIEND_NAME");
                fwd.addFriend(name);
                Toast.makeText(FWDActivity.this, name + " was added to the array", Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }
}
