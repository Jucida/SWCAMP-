package org.androidtown.test2intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity implements OnItemClickListener{

    private ArrayList<ListData> listDataArray = new ArrayList<ListData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_listview);

        ListData data1 = new ListData("1 - 첫번째 줄", " 1 - 두번째 줄", "photo1.png");
        listDataArray.add(data1);

        ListData data2 = new ListData("2 - 첫번째 줄", " 2 - 두번째 줄", "photo2.png");
        listDataArray.add(data2);

        ListData data3 = new ListData("3 - 첫번째 줄", " 3 - 두번째 줄", "photo3.png");
        listDataArray.add(data3);

        ListView listView = (ListView)findViewById(R.id.custom_list_listview);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_list_row, listDataArray);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("TEST", (position+1) + "번 리스트 선택됨");
        Log.i("TEST", "리스트 내용" + listDataArray.get(position).getText1());
    }
}
