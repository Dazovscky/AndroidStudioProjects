package com.anal.art.test;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Tracker mTracker;

    Button Ok = (Button)findViewById(R.id.ok1);
    Button Close =(Button)findViewById(R.id.close);
    TextView Text = (TextView)findViewById(R.id.Et1);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnalyticsApplication application=(AnalyticsApplication) getApplication();
        mTracker=application.getDefaultTracker();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok1:
                Text.setText("Бля!!!");
                break;
            case R.id.close:
                Text.setText("Нихуя!");
                break;
        }
    }
    @Override
    public class AnalyticsApplication extends Application {


        synchronized public Tracker getDefaultTracker() {

            if (mTracker == null) {
                GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
                mTracker = analytics.newTracker(R.xml.global_tracker);
            }
            return mTracker;
        }
    }
}
