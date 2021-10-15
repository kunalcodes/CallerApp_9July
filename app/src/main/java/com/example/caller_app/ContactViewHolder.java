package com.example.caller_app;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mTvNumber;
    private CardView mCvCardView;
    private ItemClickListener itemClickListener;

    // using this constructor, interface is passed from adapter to view holder and initialized here
    public ContactViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mCvCardView = itemView.findViewById(R.id.cvCardView);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvNumber = itemView.findViewById(R.id.tvNumber);
    }

    // the data is bound to the views in the item layout
    public void setData(Contact contact) {
        mTvName.setText(contact.getName());
        mTvNumber.setText(contact.getNumber());
        mCvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), contact);
            }
        });
    }
}
