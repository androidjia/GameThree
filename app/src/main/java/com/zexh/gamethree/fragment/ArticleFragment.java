package com.zexh.gamethree.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zexh.gamethree.R;
import com.zexh.gamethree.adapter.MainArticleFragmentViewPagerAdapter;
import com.zexh.gamethree.adapter.MainFragmentPagerAdapter;
import com.zexh.gamethree.adapter.PulltorefreshlistviewAdapter;
import com.zexh.gamethree.customView.MainArticleFragmentViewPager;
import com.zexh.gamethree.utils.LoadJsonAsynTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ArticleFragment extends Fragment {

    private static  int page = 1;
    private int typeId;
    private Context context;
    PullToRefreshListView pullToRefreshListView;

    private List<HashMap<String,Object>> data;
    private final String path = "http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=20&val=100511D3BE5301280E0992C73A9DEC41&pageIndex=";
    private PulltorefreshlistviewAdapter pulltorefreshlistviewAdapter;

    MainArticleFragmentViewPagerAdapter mainArticleFragmentViewPagerAdapter;
    @SuppressLint("ValidFragment")
    public ArticleFragment(int typeId,Context context){
        this.typeId = typeId;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.activity_mian_articlefragment,null);

        //获取Fragment中的ViewPager
        MainArticleFragmentViewPager  mainArticleFragmentViewPager = (MainArticleFragmentViewPager) view.findViewById(R.id.activity_mian_articlefragment_viewpager);
       int imageRsId[] = {R.drawable.default1,R.drawable.default2,R.drawable.default3};
        List<ImageView> imageViews = new ArrayList<>();
        for (int i=0;i<3;i++){
            ImageView imageView = new ImageView(getActivity());
            //设置图片的缩放类型 铺满全屏
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageRsId[i]);
            imageViews.add(imageView);
        }
        mainArticleFragmentViewPagerAdapter = new MainArticleFragmentViewPagerAdapter(imageViews);
        mainArticleFragmentViewPager.setAdapter(mainArticleFragmentViewPagerAdapter);


        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.activity_main_articlefragment_pulltorefresh_listview);
        data = new ArrayList<>();
        pulltorefreshlistviewAdapter = new PulltorefreshlistviewAdapter(data,context);

        switch (typeId){
            case 1:
            pullToRefreshListView.setAdapter(pulltorefreshlistviewAdapter);
            LoadJsonAsynTask task = new LoadJsonAsynTask(context,data,pulltorefreshlistviewAdapter);
            task.execute(path+page);
                pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                        LoadJsonAsynTask task1 = new LoadJsonAsynTask(context,data,pulltorefreshlistviewAdapter);
                        task1.execute(path+page++);
                     //   LoadJsonAsynTask.isloadFinish = false;
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        page++;
                        new LoadJsonAsynTask(context,data,pulltorefreshlistviewAdapter).execute(path+page);
                      //  LoadJsonAsynTask.isloadFinish = false;
                    }
                });
           // pullToRefreshListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//               boolean isBottom = false;
//                @Override
//                public void onScrollStateChanged(AbsListView absListView, int i) {
//                    if (i==0&&isBottom){
//                        if (LoadJsonAsynTask.isloadFinish){
//                            page++;
//                            LoadJsonAsynTask task1 = new LoadJsonAsynTask(context,data,pulltorefreshlistviewAdapter);
//                            task1.execute(path+page);
//                            LoadJsonAsynTask.isloadFinish = true;
//                        }
//
//                    }
//                }
//
//                @Override
//                public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//                if (i+i1==i2){
//                    isBottom = true;
//                }else {
//                    isBottom = false;
//                }
//                }
//            });

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;

        }


        return view;
    }
}
