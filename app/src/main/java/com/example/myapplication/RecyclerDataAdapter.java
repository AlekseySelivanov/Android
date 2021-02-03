package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.ViewHolder> {
    private ArrayList<String> data;
    private IRVOnItemClick onItemClickCallBack;
    public RecyclerDataAdapter(ArrayList<String> data, IRVOnItemClick onItemClickCallback) {
        this.data = data;
        this.onItemClickCallBack = onItemClickCallback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setItemText(holder, data.get(position));
        setOnClickForItem(holder, data.get(position));

    }

    @Override
    public int getItemCount() {
        return data == null ? 0: data.size();
    }

    private void setItemText(@NonNull ViewHolder holder, String text) {
        holder.textView.setText(text);
    }
    private void setOnClickForItem(@NonNull ViewHolder holder, String text) {
        holder.layout.setOnClickListener(v -> {
            if(onItemClickCallBack != null) {
                onItemClickCallBack.onItemClicked(text);
            }
        });
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        FrameLayout layout;
TextView textView;

public ViewHolder (@NonNull View itemView){
    super(itemView);
    layout = itemView.findViewById(R.id.listItemLayout);
    textView = itemView.findViewById(R.id.itemTextView);
}
    }
}
