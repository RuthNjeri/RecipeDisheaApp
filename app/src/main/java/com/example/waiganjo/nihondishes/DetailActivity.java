package com.example.waiganjo.nihondishes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
 TextView tvTitle,tvDesc;
 ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tvTitle= (TextView) findViewById(R.id.tvTitle);
        tvDesc= (TextView) findViewById(R.id.tvDesc);
        img= (ImageView) findViewById(R.id.imageView2);
        int pos=getIntent().getExtras().getInt("pos");
        Dish d=Utility.getAllDishes().get(pos);
        tvTitle.setText(d.getTitle());
        tvDesc.setText(d.getDesc());
        img.setImageResource(d.getImage());
    }

}
