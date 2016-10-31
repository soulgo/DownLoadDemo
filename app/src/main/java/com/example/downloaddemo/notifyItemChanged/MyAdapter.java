package com.example.downloaddemo.notifyItemChanged;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import com.example.downloaddemo.R;

/**
 * Created by：赖上罗小贱 on 2016/10/31
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    public String[] data;
    private Context context;

    public MyAdapter(Context context, String[] data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.tvItem.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;
        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
