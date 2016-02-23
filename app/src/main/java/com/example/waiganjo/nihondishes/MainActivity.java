package com.example.waiganjo.nihondishes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.graphics.drawable.ColorDrawable;
import android.R.color;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
CustomAdapter adapter;
ArrayList<Dish> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         //getActionBar().setTitle("Japanese");
        // getActionBar().
         //setBackgroundDrawable(new ColorDrawable(Color.rgb(244, 115, 9)));


        list= (ListView) findViewById(R.id.listView);
        data=Utility.getAllDishes();
        adapter=new CustomAdapter(this,data);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent z = new Intent(getApplicationContext(), DetailActivity.class);
                z.putExtra("pos", position);
                startActivity(z);
            }
        });
        registerForContextMenu(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

                //menu.add("share")
        //menu.add("Delete")
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("What Do You Want ?");
        menu.add("Share");
        menu.add("Delete");
        menu.add("Favourite");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        final int pos=info.position;
        Dish x=data.get(pos);
        if (item.getTitle().equals("Share"))
        {
            Intent s=new Intent(Intent.ACTION_SEND);
            s.setType("text/plain");
            s.putExtra(Intent.EXTRA_TEXT, x.getDesc());
            startActivity(s);
        }
        else if(item.getTitle().equals("Delete"))
        {
            final AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Confirm");
            builder.setMessage("Do you really want to delete?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            data.remove(pos);
                            adapter.notifyDataSetChanged();
                        }
                    }
            );
            AlertDialog.Builder builder1 = builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog dialog1 = builder.create();
                    dialog1.show();
                }
            });


        }
        else if(item.getTitle().equals("Favourite"))
        {
          //
        }

        return super.onContextItemSelected(item);
    }
}
