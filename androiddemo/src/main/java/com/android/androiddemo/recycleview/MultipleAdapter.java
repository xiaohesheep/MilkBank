package com.android.androiddemo.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.androiddemo.R;
import com.android.androiddemo.model.MyModel;

import java.util.List;

/**
 * Discription:
 * Created by guokun on 2020/5/11.
 */
public class MultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MyModel> data;

    public MultipleAdapter(List<MyModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MyModel myModel = data.get(position);
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvTitle.setText(String.valueOf(position));
        myViewHolder.tvName.setText(myModel.name);
        myViewHolder.tvDisc.setText(myModel.dis);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvName;
        public TextView tvDisc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDisc = itemView.findViewById(R.id.tv_dis);
        }
    }
}
