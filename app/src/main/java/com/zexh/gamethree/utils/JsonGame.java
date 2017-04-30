package com.zexh.gamethree.utils;

import android.util.Log;

import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class JsonGame {
    /**
     * 去除bom报头
     *  google之后发现是BOM报头问题。服务器端是php，
     *  返回的接送数据'{'前有bom报头，
     *  java读的时候把报头直接当作文件内容读，然后就会出错。
     */
    public static String formatString(String s){
        if (s!=null){
            s = s.replaceAll("\ufeff","");
        }
        return s;
    }
    public static List<HashMap<String,Object>> getGame(String path){
        String jsonPath = formatString(path);
        List<HashMap<String,Object>> datas =null;
        try {
            JSONObject roots = new JSONObject(jsonPath);
            JSONObject datat = roots.getJSONObject("data");
            datas = new ArrayList<>();
            for (int i=0;i<20;i++){
                JSONObject jsonObject = datat.getJSONObject(i+"");
                String title = jsonObject.getString("title");
                String litpic ="http://www.3dmgame.com"+jsonObject.getString("litpic");
                String description = jsonObject.getString("description");
                HashMap<String,Object> map = new HashMap<>();
                map.put("title",title);
                map.put("litpic",litpic);
                map.put("description",description);
                datas.add(map);
            }
            return datas;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
