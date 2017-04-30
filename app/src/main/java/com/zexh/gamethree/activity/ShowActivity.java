package com.zexh.gamethree.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zexh.gamethree.MainActivity;
import com.zexh.gamethree.R;
import com.zexh.gamethree.view.ListViewSwipeGesture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_back;
    private TextView tv_refresh;

    private ArrayList<HashMap<String,Object>> data ;
    private ListView groupManList;
    private BaseAdapter baseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        data = new ArrayList<>();
        initView();
        initData();
        initListener();


    }

    private void initData() {
        for (int i=0;i<30;i++){
            HashMap<String,Object> itemData = new HashMap<>();
            itemData.put("ManName","阿根廷球迷"+i);
            itemData.put("LastTime","最近发言：十分钟以前");
            data.add(itemData);
        }
        baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int i) {
                return data.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ViewHolder holder = null;
                if (view==null){
                    view = LayoutInflater.from(ShowActivity.this).inflate(R.layout.manager_group_list_item_parent,null);
                    holder = new ViewHolder();
                    holder.tv_name = (TextView) view.findViewById(R.id.ManName);
                    holder.tv_time = (TextView) view.findViewById(R.id.LastTime);
                    view.setTag(holder);
                }else {
                    holder = (ViewHolder) view.getTag();
                }
                holder.tv_name.setText(data.get(i).get("ManName")+"");
                holder.tv_time.setText(data.get(i).get("LastTime")+"");
                return view;
            }
        };

        groupManList.setAdapter(baseAdapter);
        ListViewSwipeGesture touchListener = new ListViewSwipeGesture(groupManList,
                swipeListener,this);
        touchListener.SwipeType = ListViewSwipeGesture.Double;//设置两个选项列表项的背景
        groupManList.setOnTouchListener(touchListener);
    }
    class  ViewHolder{
        TextView tv_name;
        TextView tv_time;
    }
    private void initListener() {
        tv_back.setOnClickListener(this);
        tv_refresh.setOnClickListener(this);
    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.text_show_back);
        tv_refresh = (TextView) findViewById(R.id.text_show);
        groupManList = (ListView) findViewById(R.id.GroupManList);

    }
    ListViewSwipeGesture.TouchCallbacks swipeListener = new ListViewSwipeGesture.TouchCallbacks() {
        @Override
        public void FullSwipeListView(int position) {
            Toast.makeText(ShowActivity.this, "Action_2", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void HalfSwipeListView(int position) {
                data.remove(position);
                baseAdapter.notifyDataSetChanged();
            Toast.makeText(ShowActivity.this,"删除", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void OnClickListView(int position) {

        }

        @Override
        public void LoadDataForScroll(int count) {

        }

        @Override
        public void onDismiss(ListView listView, int[] reverseSortedPositions) {

        }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_show_back:
                finish();
                break;
            case R.id.text_show:
                Intent in = new Intent(ShowActivity.this, MainActivity.class);
                startActivity(in);
                break;
        }

    }
}
