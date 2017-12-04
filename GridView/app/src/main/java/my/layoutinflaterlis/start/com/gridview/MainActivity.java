package my.layoutinflaterlis.start.com.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    GridView gvMain;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, data);
        gvMain = (GridView) findViewById(R.id.gvMain);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }
    private void adjustGridView(){
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(100);
        gvMain.setVerticalSpacing(8);
        gvMain.setHorizontalSpacing(1);
        gvMain.setStretchMode(GridView.NO_STRETCH);
    }

}
