package com.bojue.homy.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.NeedItem;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 */

public class FindNeedAdapter extends RecyclerView.Adapter<FindNeedAdapter.ViewHolder> {
    private final List<NeedItem> mNeedItems;

    public FindNeedAdapter(List<NeedItem> NeedItems) {
        mNeedItems = NeedItems;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_user_name;
        TextView txt_date;
        TextView txt_content;
        TextView txt__place;
        TextView txt_price_ic;

        public ViewHolder(View itemView) {
            super(itemView);
             txt_user_name = itemView.findViewById(R.id.txt_user_name);
             txt_date = itemView.findViewById(R.id.txt_date);
            txt_content = itemView.findViewById(R.id.txt_content);
            txt__place = itemView.findViewById(R.id.txt_place);
            txt_price_ic = itemView.findViewById(R.id.txt_price_ic);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_need_item,parent,false);
        final ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final  int position) {
        NeedItem mNeedItem = mNeedItems.get(position);
        holder.txt_user_name.setText(mNeedItem.getUsername());
        holder.txt_date.setText(mNeedItem.getDate());
        holder.txt_price_ic.setText(mNeedItem.getPrice());

    }

    @Override
    public int getItemCount() {
        return mNeedItems.size();
    }
}
