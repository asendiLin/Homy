package com.bojue.homy.view.adapter;

import android.app.IntentService;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bojue.homy.entity.ChatMessageBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 * 聊天界面的Adapter
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private Context mContext;
    private List<ChatMessageBean> mChatMessageBeanList;
    public ChatAdapter(Context context, List<ChatMessageBean> chatMessageBeanList) {
        mContext = context;
        mChatMessageBeanList = chatMessageBeanList;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mChatMessageBeanList.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout rlSender;
        public RelativeLayout rlReceiver;
        private ImageView senderPic;
        private ImageView receiverPic;
        private TextView tvSendContent;
        private TextView tvReceiveContent;
        public ChatViewHolder(View itemView) {
            super(itemView);
        }
    }
}
