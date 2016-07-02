package com.cowboyaliens.coffee;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private ArrayList<Order> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView tvOrder,tvFrom,tvDate;
        RelativeLayout relativeLayout;

        public ViewHolder(View v) {
            super(v);
            mView = v;

            tvOrder = (TextView) mView.findViewById(R.id.tv_name);
            tvFrom = (TextView) mView.findViewById(R.id.tv_from);
            tvDate = (TextView) mView.findViewById(R.id.tv_date);

            relativeLayout = (RelativeLayout) mView.findViewById(R.id.container);
        }
    }

    public OrderAdapter(ArrayList<Order> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvFrom.setText(mDataset.get(position).getOrderFrom());
        holder.tvDate.setText(mDataset.get(position).getOrderDate());
        holder.tvOrder.setText(mDataset.get(position).getOrderName());

        if (mDataset.get(position).getOrderFrom().equalsIgnoreCase("regi")){
            holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(holder.mView.getContext(),R.color.colorAccent));
        }else{
            holder.relativeLayout.setBackgroundColor(ContextCompat.getColor(holder.mView.getContext(),R.color.white));
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}



