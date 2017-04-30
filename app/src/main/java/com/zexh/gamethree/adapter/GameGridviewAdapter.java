package com.zexh.gamethree.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient.*;
import com.squareup.picasso.Picasso;
import com.zexh.gamethree.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class GameGridviewAdapter extends BaseAdapter {

    Context context;
    List<HashMap<String,Object>> gameData;
//    public static HashMap<String,Object> cacheImages;
//    static {
//        cacheImages = new HashMap<>();
//    }
    public GameGridviewAdapter(Context context, List<HashMap<String, Object>> data) {
        this.context = context;
        this.gameData = data;
    }

    @Override
    public int getCount() {
        return gameData.size();
    }

    @Override
    public Object getItem(int i) {
        return gameData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         ViewHold viewHolder = null;
        if (view==null){
            view = View.inflate(context, R.layout.gamefragment_gridview_item,null);
            viewHolder = new ViewHold();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.gamefragment_gridview_imageview);
            viewHolder.textView = (TextView) view.findViewById(R.id.gamefragment_gridview_textview);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHold) view.getTag();
        }
        viewHolder.textView.setText(gameData.get(i).get("title").toString());
        String imgPath = gameData.get(i).get("litpic").toString();
        Picasso.with(context).load(imgPath).into(viewHolder.imageView);


//        OkHttpClientManager.displayImage(viewHolder.imageView,
//                imgPath);


        return view;
    }
    static class ViewHold {
        ImageView imageView;
        TextView textView;
    }
}
