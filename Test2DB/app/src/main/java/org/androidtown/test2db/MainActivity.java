package org.androidtown.test2db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button writeBtn;
    private Button refreshBtn;
    private ListView listView;
    private ArrayList<Article> articleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        writeBtn = (Button)findViewById(R.id.activity_write);
        writeBtn.setOnClickListener(this);
        refreshBtn = (Button)findViewById(R.id.activity_refresh);
        refreshBtn.setOnClickListener(this);
        listView = (ListView)findViewById(R.id.main_listView);

        refreshData();

    }

    @Override
    public void onClick(View v) {

        }

    private static AsyncHttpClient client = new AsyncHttpClient();

    private void refreshData(){
        client.get("http://10.53.128.136:3000/loadData", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //DB에 JSON데이터 저장
                String jsonData = new String(bytes);
                Log.i("test", "jsonData: " + jsonData);

                Dao dao = new Dao(getApplicationContext());
                dao.insertJsonData(jsonData);

                listView();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }
        });
    }

//    private void refreshData(){
//        //서버로부터 JSON데이터 받아옴
//        Proxy proxy = new Proxy();
//        String jsonData = proxy.getJSON();
//
//        //DB에 JSON데이터를 저장함
//        Dao dao = new Dao(getApplicationContext());
//        dao.insertJsonData(jsonData);
//    }



    private void listView(){
        Dao dao = new Dao(getApplicationContext());
        //!!!!!!이게 adapter보다 뒤에가면 안된다!! - 라인의 관계 공부한다.
        articleList = dao.getArticleList();

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_list_row, articleList);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
