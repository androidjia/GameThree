package com.zexh.gamethree.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/2/24.
 */
public class HttpUtils {
    public static byte[] request(String stringPath){
        ByteArrayOutputStream baos = null;
        try{
            URL url = new URL(stringPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.connect();
            if (connection.getResponseCode()== HttpURLConnection.HTTP_OK){
                InputStream is = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024*4];
                int len = 0;
                while ((len=is.read(bytes))!=-1){
                    baos.write(bytes,0,len);
                }
                is.close();
                return baos.toByteArray();
            }
        }catch (Exception e){

        }
        return null;
    }
}
