package com.zexh.gamethree.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.zexh.gamethree.adapter.PulltorefreshlistviewAdapter;

/**
 * Created by Administrator on 2017/2/24.
 */
public class LoadImageAsyncTask extends AsyncTask<String,Void,byte[]> {
    private ImageView iv;
    private Context context;
    private String imgurlpath;

    public LoadImageAsyncTask(ImageView iv, Context context) {
        this.iv = iv;
        this.context = context;
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        imgurlpath = strings[0];
        return HttpUtils.request(strings[0]);
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
        if (bytes!=null){

            if (imgurlpath.equals(iv.getTag())){
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                iv.setImageBitmap(bitmap);
                PulltorefreshlistviewAdapter.cacheImg.put(imgurlpath,bitmap);
            }
        }else {
            Toast.makeText(context,"图片下载失败...", Toast.LENGTH_SHORT).show();
        }
    }
}
