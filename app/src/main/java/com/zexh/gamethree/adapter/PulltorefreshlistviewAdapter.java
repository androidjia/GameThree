package com.zexh.gamethree.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zexh.gamethree.R;
import com.zexh.gamethree.utils.LoadImageAsyncTask;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class PulltorefreshlistviewAdapter extends BaseAdapter {
    List<HashMap<String,Object>> data;
    Context context;
    public static HashMap<String,Object> cacheImg;
    static {
        cacheImg = new HashMap<>();
    }
    public PulltorefreshlistviewAdapter(List<HashMap<String, Object>> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view==null){
            view = View.inflate(context, R.layout.articlefragment_pulltorefreshlistview_item,null);
            holder = new ViewHolder();
            holder.tv_subject = (TextView) view.findViewById(R.id.tv_subject);
            holder.tv_summary = (TextView) view.findViewById(R.id.tv_summary);
            holder.iv = (ImageView) view.findViewById(R.id.iv);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_subject.setText(data.get(i).get("subject").toString());
        holder.tv_summary.setText(data.get(i).get("summary").toString());
        String imgurlpath = data.get(i).get("cover").toString();
        holder.iv.setTag(imgurlpath);
        holder.iv.setImageResource(R.mipmap.ic_launcher);
        if (cacheImg.containsKey(imgurlpath)){
            holder.iv.setImageBitmap((Bitmap) cacheImg.get(imgurlpath));
        }else {
            LoadImageAsyncTask imageAsyncTask = new LoadImageAsyncTask(holder.iv,context);
            imageAsyncTask.execute(imgurlpath);
        }
        return view;
    }
    static class ViewHolder{
        ImageView iv;
        TextView tv_subject;
        TextView tv_summary;
    }
}
