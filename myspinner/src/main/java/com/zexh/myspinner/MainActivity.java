package com.zexh.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
   Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.sp);
        String[] strings =  { "动作(ACT)", "射击(FPS)","角色扮演（RPG)",
                "养成(GAL)","益智(PUZ)", "即时战略(RTS)","策略(SLG)",
                "体育(SPG)","模拟经营(SIM)","赛车(RAC)","冒险(AVG)", "动作角色(ARPG)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sp_item,R.id.tv,strings);

        spinner.setAdapter(adapter);
    }
}
