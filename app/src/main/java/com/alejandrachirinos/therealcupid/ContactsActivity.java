package com.alejandrachirinos.therealcupid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alejandrachirinos.therealcupid.adapter.ContactsAdapter;
import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {
    public static String LOG = MenuActivity.class.getName();

    private Context context;
    private User user;
    private List<User> items = new ArrayList<>();

    private Button addButton;
    private ContactsAdapter adapter;
    private ListView contactsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.contacts_layout);
        Log.e(LOG, "onCreateContacts");

        receiveValues();
        initViews();
        addEvents();
        fillContacts();
    }

    private void receiveValues() {
        Intent intent = getIntent();

        if (intent.hasExtra(Constants.INTENT_KEY_USER)) {

            String userObj = intent.getStringExtra(Constants.INTENT_KEY_USER);

            user = new Gson().fromJson(userObj, User.class);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG, "onStart11111");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG, "onResume1111");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG, "onPause1111");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG, "onStop1111");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG, "onDestroy");
    }

    private void initViews() {
        contactsListView = findViewById(R.id.contactsListView);
        adapter = new ContactsAdapter(context, items);
        contactsListView.setAdapter(adapter);
    }

    private void addEvents() {
        Log.e(LOG, "events1");

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                User contact = items.get(position);
                items.clear();
                adapter.notifyDataSetChanged();
            }
        });
        Log.e(LOG, "events2");

    }

    private void fillContacts() {
        items.add(new User("prueba","prueba","prueba","p@g",50000,"abc","sistemas",null, 20));
        if(user != null && user.getContacts()!=null) {
            for (User e : user.getContacts()) {
                items.add(e);
            }
        }

        Log.e(LOG, "fiiiiiil");

    }

}
