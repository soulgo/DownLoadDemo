package com.example.downloaddemo.update;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.downloaddemo.R;

import java.util.List;

/**
 * Created by：赖上罗小贱 on 2016/10/31
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class DataAdapter extends BaseAdapter{
    private ListView listView;
    private List<MyListItem> list;
    private LayoutInflater inflater;
    private TextView currentTextView;
    private ImageView currentImageView;
    private Context context;

    public DataAdapter(ListView listView, List<MyListItem> list, Context context) {
        this.listView = listView;
        this.list = list;
        this.context = context;
    }
    //公开的更新数据方法
    public void updataItemData(int positon,MyListItem item){
        Message message = new Message();
        list.set(positon,item);
        message.arg1 = positon;
        handler.sendMessage(message);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            updataData(msg.arg1);
        }
    };
//实现数据动态更新的方法过程
    public void updataData(int position) {
        if (listView == null){
            return;
        }
        int first = listView.getFirstVisiblePosition();
        View currentView = listView.getChildAt(position - first);
        currentTextView = (TextView) currentView.findViewById(R.id.item_text);
        currentImageView = (ImageView) currentView.findViewById(R.id.item_image);
        if (list.get(position).getChooseType() == 1){
            currentImageView.setImageResource(R.drawable.zhu);
        }else {
            currentImageView.setImageResource(R.drawable.gou);
        }
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item,null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.item_text);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (list.get(position).getChooseType() == 1){
            viewHolder.imageView.setImageResource(R.drawable.zhu);
        }else {
            viewHolder.imageView.setImageResource(R.drawable.gou);
        }
        viewHolder.textView.setText(list.get(position).getData());
        return convertView;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
