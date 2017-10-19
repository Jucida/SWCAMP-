package org.androidtown.test2intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 =(Button)findViewById(R.id.button);
        button1.setOnClickListener(this);
        Button button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 =(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent1 = new Intent(this, SampleList1Activity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, SampleList2Activity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, CustomListActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
