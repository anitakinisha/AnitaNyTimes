package com.nytimenews.retrofit.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nytimenews.retrofit.R;
import com.nytimenews.retrofit.model.Article;

import java.util.ArrayList;

public class ArticleItemRecyclerViewAdapter extends RecyclerView.Adapter<ArticleItemRecyclerViewAdapter.ArticleViewHolder> {

    private ArrayList<Article> dataList = null;
    private RecyclerItemClickListener recyclerItemClickListener;

    public ArticleItemRecyclerViewAdapter(ArrayList<Article> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }
    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, final int position) {

        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtbyline.setText(dataList.get(position).getByLine());
        holder.txtSource.setText(dataList.get(position).getSource());
        holder.txtpublishDate.setText(dataList.get(position).getPublishDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtbyline, txtpublishDate,txtSource;

        ArticleViewHolder(View itemView) {
            super(itemView);
            txtTitle =  itemView.findViewById(R.id.txt_title);
            txtbyline =  itemView.findViewById(R.id.txt_biline);
            txtSource = itemView.findViewById(R.id.txt_Source);
            txtpublishDate =  itemView.findViewById(R.id.txt_publishDate);
        }

    }
}
