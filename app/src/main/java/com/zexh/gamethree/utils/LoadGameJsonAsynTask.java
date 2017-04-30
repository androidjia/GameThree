package com.zexh.gamethree.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.zexh.gamethree.adapter.GameGridviewAdapter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public class LoadGameJsonAsynTask extends AsyncTask<String,Void,List<HashMap<String,Object>>> {
    private Context context;
    private List<HashMap<String,Object>> datas;
    private GameGridviewAdapter adapter;
    private int typeIds;
    private  int idType = 0;
    public LoadGameJsonAsynTask(Context context, List<HashMap<String, Object>> data, GameGridviewAdapter adapter,int typeIds) {
        this.context = context;
        this.datas = data;
        this.adapter = adapter;
        this.typeIds = typeIds;
    }

    @Override
    protected List<HashMap<String, Object>> doInBackground(String... strings) {
        byte[] b = HttpUtils.request(strings[0]);

        if (b!=null){
            try {
                String json = new String(b,"utf-8");
                return JsonGame.getGame(json);
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
            if (idType==typeIds){
            datas.addAll(hashMaps);
            }else {
                datas.clear();
                datas.addAll(hashMaps);
                idType = typeIds;
            }
            adapter.notifyDataSetChanged();
        }else {
            Toast.makeText(context, "网络或解析有异常JsonGame", Toast.LENGTH_SHORT).show();
        }
    }
}
