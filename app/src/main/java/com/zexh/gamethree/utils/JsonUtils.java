package com.zexh.gamethree.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class JsonUtils {
    public static List<HashMap<String,Object>> getList(String json){
        List<HashMap<String,Object>> data = null;
        try{
            JSONObject root = new JSONObject(json);
            JSONObject paramz = root.getJSONObject("paramz");
            JSONArray feeds = paramz.getJSONArray("feeds");
            data = new ArrayList<>();
            for (int i=0;i<feeds.length();i++){
                JSONObject jsonObject = feeds.getJSONObject(i);
                JSONObject dataObject = jsonObject.getJSONObject("data");
                String subject = dataObject.getString("subject");
                String summary = dataObject.getString("summary");
                String cover = "http://litchiapi.jstv.com"+dataObject.getString("cover");
                HashMap<String,Object> map= new HashMap<>();
                map.put("subject",subject);
                map.put("summary",summary);
                map.put("cover",cover);
                data.add(map);
            }
            return data;
        }catch (Exception e){
        }
        return null;
    }

}
