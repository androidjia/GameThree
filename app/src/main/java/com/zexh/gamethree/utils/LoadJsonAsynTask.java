package com.zexh.gamethree.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.zexh.gamethree.adapter.PulltorefreshlistviewAdapter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class LoadJsonAsynTask extends AsyncTask<String,Void,List<HashMap<String,Object>>> {
   private Context context;
    private List<HashMap<String,Object>> data;
   // public static boolean isloadFinish = false;
    private PulltorefreshlistviewAdapter adapter;

    public LoadJsonAsynTask(Context context, List<HashMap<String, Object>> data, PulltorefreshlistviewAdapter adapter) {
        this.context = context;
        this.data = data;
        this.adapter = adapter;
    }

    @Override
    protected List<HashMap<String, Object>> doInBackground(String... strings) {
        byte[] b = HttpUtils.request(strings[0]);
        if (b!=null){
            try {
                String jsons = new String(b,"utf-8");
                return JsonUtils.getList(jsons);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<HashMap<String, Object>> hashMaps) {
        super.onPostExecute(hashMaps);
        if (hashMaps!=null){
            data.addAll(hashMaps);
            adapter.notifyDataSetChanged();
         //   isloadFinish = true;
        }else {
            Toast.makeText(context, "网络或解析有异常", Toast.LENGTH_SHORT).show();
        }
    }
}
