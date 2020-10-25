package com.example.myapplication.recyecleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder> {
Context context;
List<item> itemes=new ArrayList();
callback callback;

    public adapter(Context context, List<item> itemes, com.example.myapplication.recyecleview.callback callback) {
        this.context = context;
        this.itemes = itemes;
        this.callback = callback;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_items,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
item item=itemes.get(position);
    holder.about.setText(item.getAbout().toString());
        holder.title.setText(item.getTitle().toString());
        holder.auther.setText(item.getAuther().toString());
        holder.adresseSite.setText(item.getAdresseSite().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.senddata(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemes.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView title,auther,adresseSite,about;

        public holder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.card_title);
            auther=itemView.findViewById(R.id.card_auther);
            adresseSite=itemView.findViewById(R.id.card_adresseSite);
            about=itemView.findViewById(R.id.card_about);

        }
    }
}
