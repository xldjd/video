package com.example.instantmusicvideotest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.untis.CommentBean;
import com.example.instantmusicvideotest.untis.NoScrollListView;
import com.example.instantmusicvideotest.untis.ReplyBean;

import java.io.InputStream;
import java.util.List;

public class CommentAdapter extends BaseAdapter {

    private int resourceId;
    private Context context;
    private Handler handler;
    private List<CommentBean> list;
    private LayoutInflater inflater;
    public CommentAdapter(Context context,List<CommentBean> list
            ,int resourceId,Handler handler){
        this.list = list;
        this.context = context;
        this.handler = handler;
        this.resourceId = resourceId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentBean bean = list.get(position);
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(resourceId, null);
            holder.commentItemImg = (ImageView)
                    convertView.findViewById(R.id.commentItemImg);
            holder.commentNickname = (TextView)
                    convertView.findViewById(R.id.commentNickname);
            holder.replyText = (TextView)
                    convertView.findViewById(R.id.replyText);
            holder.commentItemTime = (TextView)
                    convertView.findViewById(R.id.commentItemTime);
            holder.commentItemContent = (TextView)
                    convertView.findViewById(R.id.commentItemContent);
            holder.replyList = (NoScrollListView)
                    convertView.findViewById(R.id.replyList);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        InputStream is = context.getResources().openRawResource(bean.getCommentImgId());
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        holder.commentItemImg.setImageBitmap(bitmap);
        holder.commentNickname.setText(bean.getCommentNickname());
        holder.commentItemTime.setText(bean.getCommentTime());
        holder.commentItemContent.setText(bean.getCommentContent());

        ReplyAdapter adapter = new ReplyAdapter(context, bean.getReplyList(), R.layout.reply_item);
        holder.replyList.setAdapter(adapter);
        TextviewClickListener tcl = new TextviewClickListener(position);
        holder.replyText.setOnClickListener(tcl);

        return convertView;
    }

    private final class ViewHolder{
        public ImageView commentItemImg;			//???????????????
        public TextView commentNickname;			//???????????????
        public TextView replyText;					//??????
        public TextView commentItemTime;			//????????????
        public TextView commentItemContent;			//????????????
        public NoScrollListView replyList;			//??????????????????
    }

    /**
     * ??????????????????
     */
    public void getReplyComment(ReplyBean bean, int position){
        List<ReplyBean> rList = list.get(position).getReplyList();
        rList.add(rList.size(), bean);
    }

    /**
     * ?????????????????????
     */
    private final class TextviewClickListener implements OnClickListener{
        private int position;
        public TextviewClickListener(int position){
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.replyText:
                    handler.sendMessage(handler.obtainMessage(10, position));
                    break;
            }
        }
    }

}

