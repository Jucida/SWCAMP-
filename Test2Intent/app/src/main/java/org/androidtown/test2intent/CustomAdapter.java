package org.androidtown.test2intent;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ListData>{
        private Context context;
        private int layoutResourceId;
        private ArrayList<ListData> listData;

    //생성자
    public CustomAdapter(Context context, int layoutResourceId, ArrayList<ListData> listData){
            super(context, layoutResourceId, listData);
            this.context = context;
            this.layoutResourceId = layoutResourceId;
            this.listData = listData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        // row.findViewByid로 row안의 레이아웃을 구성합니다.
        TextView tvText1 = (TextView) row.findViewById(R.id.custom_row_textView1);
        TextView tvText2 = (TextView) row.findViewById(R.id.custom_row_textView2);

        // position은 listData 리스트의 순서값(index)입니다.
        // listdata(어레이리스트) ListData(객체)를 가져와
        // get으로 순서값을 불러온 후  setText해줍니다.
        tvText1.setText(listData.get(position).getText1());
        tvText2.setText(listData.get(position).getText2());

        ImageView imageView = (ImageView) row.findViewById(R.id.custom_row_imageView);

        try {
            //이미지의 파일 이름을 불러옵니다.
            InputStream is = context.getAssets().open(listData.get(position).getImgName());
            //이미지를 불러와 Drawable로 만들고
            Drawable d = Drawable.createFromStream(is, null);
            //이미지뷰에 표시합니다.
            imageView.setImageDrawable(d);
        }catch (IOException e){
            Log.e("ERROR","ERROR: " + e);
        }
        return row;
    }
}

