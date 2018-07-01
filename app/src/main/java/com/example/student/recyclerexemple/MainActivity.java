package com.example.student.recyclerexemple;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager1;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // data
        final ArrayList<Model> items = new ArrayList<>();
        Model model1 = new Model("Vanadzor", "ttt");
        final Model model2 = new Model("Yerevan", "ttt");
        Model model3 = new Model("Gyumri", "ttt");
        Model model4 = new Model("Alaverdi", "ttt");

        items.add(model1);
        items.add(model2);
        items.add(model3);
        items.add(model4);
        items.add(model1);
        items.add(model1);
        items.add(model1);
        items.add(model1);
        items.add(model1);
        items.add(model1);
        items.add(model1);



        // adapter
        final MyAdapter adapter = new MyAdapter(items, this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(model2);
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(items.size()-1);
            }
        });

        // recylerView

        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        //layoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager1 = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager1);
       // recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager1 = new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(layoutManager1);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            layoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
        }
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
}
