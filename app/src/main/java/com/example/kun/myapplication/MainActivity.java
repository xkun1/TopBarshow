package com.example.kun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopBar topBar= (TopBar) findViewById(R.id.topbar);

        if (topBar != null) {
            topBar.setClickLister(new TopBar.topBarClickLister() {
                @Override
                public void leftClick() {
                    Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_LONG).show();
                }

                @Override
                public void rightClick() {
                    Toast.makeText(MainActivity.this,"多功能",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
