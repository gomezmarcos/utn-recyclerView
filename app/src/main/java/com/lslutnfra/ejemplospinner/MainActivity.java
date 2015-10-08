package com.lslutnfra.ejemplospinner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 1001;
    public static ArrayList<Persona> personas ;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        ArrayList<String> personas = null; // = new ArrayList<String>();
        personas.add("opcion 1");
        */

        personas = new ArrayList<>();
        for(int i=0; i<100; i++)
            personas.add(new Persona("pepito "+i,"perez"));

        RecyclerView rv = (RecyclerView) findViewById(R.id.list);

        adapter = new MyAdapter(this, personas);

        rv.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    public void metodoLoco(int position){
        Persona persona = personas.get(position);
        Log.e("metodoLoco", "se hizo click en item: " + persona.getNombre());
        Bundle bundle = new Bundle();
        bundle.putString("ape", persona.getApellido());
        bundle.putInt("position", position);
        Intent intent = new Intent(this,NextActivity.class);
        intent.putExtras(bundle);

        //startActivity(intent);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK){
            adapter.notifyDataSetChanged();
        }
    }
}
