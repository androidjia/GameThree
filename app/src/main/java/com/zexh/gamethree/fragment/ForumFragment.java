package com.zexh.gamethree.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zexh.gamethree.R;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ForumFragment extends Fragment {
    WebView webView ;
    String url = "http://bbs.3dmgame.com/forum.php";
    WebSettings webSettings;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_forumfragment,null);
        webView = (WebView) view.findViewById(R.id.forumfragment_webview);
        webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        return view;
    }
}
