package org.androidtown.test2intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.layout.simple_list_item_2;

public class SampleList2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list2);

        ListView listView = (ListView)findViewById(R.id.simple_list2_listView);
        ArrayList<HashMap<String, String>> hashMapList1 = new ArrayList<HashMap<String, String>>(2);

        for (int i = 0; i < 10; i++){
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("line1", "첫번째 줄의" + i + "번");
            map.put("line2", "두번째 줄의" + i + "번");
            hashMapList1.add(map);
        }

        String[] from = {"lin1", "lin2"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter simpleAdapter2 = new SimpleAdapter(this, hashMapList1, simple_list_item_2, from, to);
        listView.setAdapter(simpleAdapter2);
    }
}
