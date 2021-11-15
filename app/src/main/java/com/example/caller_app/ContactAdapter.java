package com.example.caller_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> contactList;
    private ItemClickListener itemClickListener;

    /* adapter is created from this constructor and list is passed from the activity
    which is initialized here
     */
    public ContactAdapter(ArrayList<Contact> contactArrayList, ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
        this.contactList = contactArrayList;
    }

    //this method inflates the layout for individual item
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ContactViewHolder(view, itemClickListener);
    }

    //here data from the list is bound to the created views
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.setData(contact);
    }

    //returns the list size so recyclerview knows the size
    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
