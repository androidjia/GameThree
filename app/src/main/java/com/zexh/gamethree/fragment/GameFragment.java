package com.zexh.gamethree.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.zexh.gamethree.R;
import com.zexh.gamethree.activity.CheckActivity;
import com.zexh.gamethree.adapter.GameGridviewAdapter;
import com.zexh.gamethree.utils.LoadGameJsonAsynTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
public class GameFragment extends Fragment implements View.OnClickListener{
    Context context;
   // PullToRefreshGridView gridView;
    GridView gridView;
    List<HashMap<String,Object>> gridviewData;
    GameGridviewAdapter gameGridviewAdapter;
    Spinner spinner;
    String sp_data[];
    private int  typeid = 179;
    private int page = 1;
    String urlPath = "http://www.3dmgame.com/sitemap/api.php?row=20&typeid=";
    String urlPathw = "&paging=1&page=";
    private TextView tv_send;
    public GameFragment(){}
    @SuppressLint("ValidFragment")
    public GameFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.activity_main_gamefragment,null);
        tv_send = (TextView) view.findViewById(R.id.text_gamefragment);
        gridView = (GridView) view.findViewById(R.id.gamefragment_gridview);
       spinner = (Spinner) view.findViewById(R.id.gamefragment_spinner);
        sp_data = new String[] { "动作(ACT)", "射击(FPS)","角色扮演（RPG)",
                "养成(GAL)","益智(PUZ)", "即时战略(RTS)","策略(SLG)",
                "体育(SPG)","模拟经营(SIM)","赛车(RAC)","冒险(AVG)", "动作角色(ARPG)"};
        ArrayAdapter sp_adapter = new ArrayAdapter(context,R.layout.gamefragment_spinner_item,R.id.spinner_tv,sp_data);
        gridviewData = new ArrayList<>();
        gameGridviewAdapter = new GameGridviewAdapter(context,gridviewData);
        gridView.setAdapter(gameGridviewAdapter);
        LoadGameJsonAsynTask task = new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid);
        task.execute(urlPath+typeid+urlPathw+page);
        spinner.setSelection(0, true);
        spinner.setAdapter(sp_adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        typeid =181;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                     case 1:
                         typeid =182;
                         page = 1;
                         new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                 .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 2:
                        typeid =183;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                     case 3:
                         typeid =184;
                         page = 1;
                         new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                 .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 4:
                        typeid =185;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 5:
                        typeid =186;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 6:
                        typeid =187;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 7:
                        typeid =188;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 8:
                        typeid =189;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 9:
                        typeid =190;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 10:
                        typeid =191;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    case 11:
                        typeid =192;
                        page = 1;
                        new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                                .execute(urlPath+typeid+urlPathw+page);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            boolean isButton = false;
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i==0&&isButton==true){
                    page++;
                    new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter,typeid)
                            .execute(urlPath+typeid+urlPathw+page);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i+i1==i2){
                    isButton = true;
                }else {
                    isButton = false;
                }
            }
        });
//        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
//                page++;
//                LoadGameJsonAsynTask task = new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter);
//                task.execute(urlPath+page);
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
//                page++;
//                LoadGameJsonAsynTask task = new LoadGameJsonAsynTask(context,gridviewData,gameGridviewAdapter);
//                task.execute(urlPath+page);
//            }
//        });
        initListener();
        return view;
    }

    private void initListener() {
        tv_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_gamefragment:
                Intent checkIntent = new Intent(getActivity(), CheckActivity.class);
                startActivity(checkIntent);
                break;
        }
    }
}
