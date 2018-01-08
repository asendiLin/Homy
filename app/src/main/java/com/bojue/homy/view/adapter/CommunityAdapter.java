package com.bojue.homy.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.CommunityBean;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 * 社区列表的适配器
 */

    public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.ViewHolder> {
        private final List<CommunityBean> mCommunityList;
        private Context mContext;
        private OnItemClickListener mListener;

        public CommunityAdapter(List<CommunityBean> communityList, Context context) {
            mCommunityList = communityList;
            this.mContext=context;
        }

    public void setItemListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
            TextView name_community;
            TextView date_community;
            ImageButton comment_community;

            public ViewHolder(View view) {
                super(view);
                name_community = view.findViewById(R.id.name_community);
                date_community = view.findViewById(R.id.date_community);
                comment_community = view.findViewById(R.id.comment_community);
            }
        }
        @Override
        public CommunityAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_item,parent,false);
            ViewHolder holder = new ViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(CommunityAdapter.ViewHolder holder, final int position) {
            CommunityBean communityBean = mCommunityList.get(position);
            holder.date_community.setText(communityBean.getDate_community());
            holder.name_community.setText(communityBean.getName_community());

            holder.comment_community.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener!=null){
                        mListener.onClick(view,position);
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
        }
    }
