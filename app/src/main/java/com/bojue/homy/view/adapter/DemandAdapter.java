package com.bojue.homy.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.PersonBean;

import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 我的需求之RecyclerView的适配器
 */

public class DemandAdapter extends RecyclerView.Adapter<DemandAdapter.ViewHolder> {
    private final String TAG= "1";
    private   List<PersonBean> mPersonList;
    private onItemClickListener mListener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView text_type;
        TextView text_start_time;
        TextView text_end_time;
        TextView text_price;
        TextView text_finish;
        ImageView un_finish;

       public ViewHolder(View view) {
           super(view);
           text_type = view.findViewById(R.id.text_type);
           text_start_time = view.findViewById(R.id.text_start_time);
           text_end_time = view.findViewById(R.id.text_end_time);
           text_price = view.findViewById(R.id.text_price);
           text_finish = view.findViewById(R.id.text_finish);
           un_finish = view.findViewById(R.id.un_finish);
       }
   }
   public DemandAdapter(List<PersonBean> personList){
       mPersonList = personList;
   }
   public void setItemListener(onItemClickListener onItemClickListener){
       mListener = onItemClickListener;
   }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_my_demand_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       PersonBean personBean = mPersonList.get(position);
        holder.text_start_time.setText(personBean.getStart_time_demand());
        holder.text_end_time.setText(personBean.getEnd_time_demand());
       holder.un_finish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(mListener != null){
                   mListener.onClick(view,position);
               }
           }
       });

    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    /**
     * 监听事件的接口
     */
    public interface onItemClickListener{
       void onClick(View view,int position);
    }

}
