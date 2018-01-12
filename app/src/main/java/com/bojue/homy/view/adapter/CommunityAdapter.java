package com.bojue.homy.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.view.fragment.community.ICommunityView;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 * 社区列表的适配器
 */

    public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.ViewHolder> {
        private final List<CommunityBean> mCommunityList;
        private Context mContext;
        private View view;
        private OnItemClickListener mListener;
        private ViewHolder holder;


    public CommunityAdapter(List<CommunityBean> communityList, Context context) {
            mCommunityList = communityList;
            this.mContext=context;
        }

    public void setItemListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public View getView(){
        return view;
    }



    class ViewHolder extends RecyclerView.ViewHolder{
            TextView name_community;
            TextView date_community;
            ImageButton comment_community;
            TextView zan_sum_community;

            public ViewHolder(View view) {
                super(view);
                name_community = view.findViewById(R.id.name_community);
                date_community = view.findViewById(R.id.date_community);
                comment_community = view.findViewById(R.id.comment_community);
                zan_sum_community = view.findViewById(R.id.zan_sum_community);
            }
        }
        @Override
        public CommunityAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_community_item,parent,false);
            holder = new ViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(CommunityAdapter.ViewHolder holder, final int position) {
            CommunityBean communityBean = mCommunityList.get(position);
            holder.date_community.setText(communityBean.getDate_community());
            holder.name_community.setText(communityBean.getName_community());
            holder.zan_sum_community.setText(" "+communityBean.getZan_sum_community());
            Log.d("========","调用"+position);

            if(communityBean.isStatus()) {
                Drawable drawable =mContext.getResources().getDrawable(R.drawable.ic_zan_filled);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                holder.zan_sum_community.setCompoundDrawables(drawable, null, null, null);
            } else {
                Drawable drawable = mContext.getResources().getDrawable(R.drawable.ic_zan);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                holder.zan_sum_community.setCompoundDrawables(drawable, null, null, null);
            }


            holder.comment_community.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener!=null){
                        mListener.onClick(view,position);
                    }
                }
            });
            holder.zan_sum_community.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener!=null){
                        mListener.onCheck(view,position);
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return mCommunityList.size();
        }


        public interface OnItemClickListener{
            //评论按钮的点击回调
            void onClick(View view,int position);

            //点赞按钮的点击回调
            void onCheck(View view,int position);
        }
    }
