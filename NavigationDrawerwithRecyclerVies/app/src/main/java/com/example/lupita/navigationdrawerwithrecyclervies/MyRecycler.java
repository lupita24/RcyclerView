package com.example.lupita.navigationdrawerwithrecyclervies;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lupita on 26/01/2016.
 */
public class MyRecycler  extends RecyclerView.Adapter<MyRecycler.ViewHolder>{

    List<Foto> news;

    MyRecycler(List<Foto> news){
        this.news = news;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre;
        ImageView photo;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.recycler);
            nombre = (TextView)itemView.findViewById(R.id.name);
            photo = (ImageView)itemView.findViewById(R.id.imagePhoto);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item,parent, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(news.get(position).namenews);
        holder.photo.setImageResource(news.get(position).photoId);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}

