package com.example.dailynews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<viewHolder> {

    ArrayList<News> item = new ArrayList<>();
   private NewsItemClicked newsItemClicked;

    public NewsListAdapter(NewsItemClicked newsItemClicked) {
        this.newsItemClicked = newsItemClicked;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        viewHolder viewHolder = new viewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsItemClicked.onitemclicked(item.get(viewHolder.getAdapterPosition()));
            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        News currentItem = item.get(position);
        holder.textView.setText(currentItem.getTitle());
        holder.authorview.setText(currentItem.getAuthor());
        Glide.with(holder.itemView.getContext()).load(currentItem.imgurl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }


    public void updateNews(ArrayList<News> updatedItem)
    {
        item.clear();
        item.addAll(updatedItem);

        notifyDataSetChanged();
    }
}

class viewHolder extends RecyclerView.ViewHolder
{

    TextView textView,authorview;
    ImageView imageView;
    public viewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title);
        authorview = itemView.findViewById(R.id.author);
        imageView = itemView.findViewById(R.id.imageView);

    }
}


