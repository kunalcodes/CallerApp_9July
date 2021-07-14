package com.example.caller_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView mTvNoContacts;
    private static final int REQ_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setRecyclerViewAdapter();
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE}, REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            recyclerView.setVisibility(View.VISIBLE);
            mTvNoContacts.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.GONE);
            mTvNoContacts.setVisibility(View.VISIBLE);
        }
    }

    private void setRecyclerViewAdapter() {
        ContactAdapter contactAdapter = new ContactAdapter(contactList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void buildRecyclerViewData() {
        for (int i=0; i<10; i++){
            contactList.add(new Contact("123456789"+i,"Abhishek"+(i+1)));
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mTvNoContacts = findViewById(R.id.tvNoContacts);
    }

    @Override
    public void onItemClicked(int position, Contact contact) {
        String uri = "tel:" + contact.getNumber() ;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }
}