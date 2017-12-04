package my.layoutinflaterlis.start.com.simpleadaptercustom1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_VALUE = "value";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    final int positive = android.R.drawable.arrow_up_float;
    final int negative = android.R.drawable.arrow_down_float;

    ListView lvSimple;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        int[] values = { 8, 4, -3, 2, -5, 0, 3, -6, 1, -1 };

        ArrayList<Map<String, Object>> data=new
                    ArrayList<Map<String, Object>>(values.length);
        Map<String, Object> m;
        int img=0;
        for (int i=0; i<values.length; i++) {
            m=new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "Day"+(i+1));
            m.put(ATTRIBUTE_NAME_VALUE, values[i]);
            if (values[i]==0) img=0; else
                img=(values[i]>1) ? positive:negative;
            m.put(ATTRIBUTE_NAME_IMAGE,img);
            data.add(m);
        }
        String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_VALUE,
                ATTRIBUTE_NAME_IMAGE };
        int[] to = { R.id.tvText, R.id.tvValue, R.id.ivImg };

        MySimpleAdapter sAdapter = new MySimpleAdapter(this, data, R.layout.item, from, to);
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
    }
    class MySimpleAdapter extends SimpleAdapter{
        public MySimpleAdapter(Context context, List<? extends  Map<String, ?>> data, int resourse,
                               String[] from, int[] to){
            super(context, data, resourse, from, to);
        }
        public void setViewTxet(TextView v, String text){
            super.setViewText(v, text);
            if (v.getId()==R.id.tvValue){
                int i=Integer.parseInt(text);
                if (i<0) v.setTextColor(Color.RED); else
                    if (i>0) v.setTextColor(Color.GREEN);
            }
        }
        @Override
        public void setViewImage(ImageView v, int value){
            super.setViewImage(v, value);

            if (value==negative) v.setBackgroundColor(Color.RED); else
                if (value==positive) v.setBackgroundColor(Color.GREEN);
        }
    }
}
