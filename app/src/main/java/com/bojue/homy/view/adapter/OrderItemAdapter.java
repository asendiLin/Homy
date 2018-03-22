package com.bojue.homy.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.PersonBean;

import java.util.List;

/**
 * Created by Xie on 2018/1/15.
 * 我的订单之RecyclerView的适配器
 */

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private List<PersonBean> mList;
    private Context getContext;
    private OnItemClickListener onItemClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView text_type;
        TextView text_start_time;
        TextView text_end_time;
        TextView text_price;
        TextView text_finish;
        ImageView un_finish;
        LinearLayout lin_order;

        public ViewHolder(View view) {
            super(view);
            lin_order = view.findViewById(R.id.lin_order);
            text_type = view.findViewById(R.id.text_type);
            text_start_time = view.findViewById(R.id.text_start_time);
            text_end_time = view.findViewById(R.id.text_end_time);
            text_price = view.findViewById(R.id.text_price);
            text_finish = view.findViewById(R.id.text_finish);
            un_finish = view.findViewById(R.id.un_finish);
        }
    }
    public OrderItemAdapter(Context context, List<PersonBean> list){
        this.mList = list;
        this.getContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(getContext);

        View view = inflater.inflate(R.layout.fragment_my_order_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        PersonBean personBean = mList.get(position);
        holder.text_start_time.setText(personBean.getStart_time_demand());
        holder.lin_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(getContext,position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onClick(Context context,int position);
    }
}
