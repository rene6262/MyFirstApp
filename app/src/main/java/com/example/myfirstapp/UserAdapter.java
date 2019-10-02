package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    Context context;
    List<String> list;

    public AdapterClickListener AdapterClickListener;
    public AdapterDeleteListen AdapterDeleteListen;

    public UserAdapter(Context context,List<String> list, AdapterClickListener AdapterClickListener, AdapterDeleteListen AdapterDeleteListen){
        this.list = list;
        this.context = context;
        this.AdapterClickListener = AdapterClickListener;
        this.AdapterDeleteListen = AdapterDeleteListen;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_display_message, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position){
        holder.textView.setText(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdapterDeleteListen.itemDeleted(position);
            }
        });
    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public UserViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textFirst);
        }
    }
}

