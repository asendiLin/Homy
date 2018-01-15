package com.bojue.homy.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.CommentBean;

import java.util.List;

/**
 * Created by lizheng on 2018/1/9.
 * 评论的适配器
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    private List<CommentBean> mCommentBeanList;
    private OnItemClickListener mListener;
    public CommentAdapter(List<CommentBean> commentBeanList) {
        mCommentBeanList = commentBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_comment_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        CommentBean commentBean = mCommentBeanList.get(position);
        holder.data_comment.setText(commentBean.getData());
        holder.name_comment.setText(commentBean.getName());
        holder.reply_comment.setText("回复:"+commentBean.getRepliedName());

        if(commentBean.isReply()){
            holder.reply_comment.setVisibility(View.VISIBLE);
        }else {
            holder.reply_comment.setVisibility(View.GONE);
        }

        holder.commentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener !=null){
                    mListener.onClick(view,position);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return mCommentBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View commentView;
        TextView name_comment;
        TextView data_comment;
        TextView reply_comment;
        public ViewHolder(View itemView) {
            super(itemView);
            name_comment = itemView.findViewById(R.id.name_comment);
            data_comment = itemView.findViewById(R.id.date_comment);
            reply_comment = itemView.findViewById(R.id.reply_comment);
            commentView = itemView;
        }
    }

    public void setItemListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemClickListener{
        void onClick(View view,int position);
    }
}
