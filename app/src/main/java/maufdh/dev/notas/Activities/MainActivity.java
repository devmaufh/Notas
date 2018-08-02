package maufdh.dev.notas.Activities;

import android.app.Application;
import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import maufdh.dev.notas.Adapters.RecyclerHomeAdapter;
import maufdh.dev.notas.Models.ModelPizarra;
import maufdh.dev.notas.R;
import maufdh.dev.notas.Settings.SettingsActivity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
    }
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar); //Muestra el toolbar como ActionBar
        setSupportActionBar(toolbar);//Muestra titulo de toolbar
    }
    private void bindUI(){
        rv=(RecyclerView)findViewById(R.id.main_rvNotes);
        btnAdd=(FloatingActionButton)findViewById(R.id.main_fab);
    }
    private void setDataRecycler(){
        mLayoutManager=new LinearLayoutManager(getApplicationContext());
        mAdapter= new RecyclerHomeAdapter(null, R.id.cardview_pizarra, new RecyclerHomeAdapter.OnItemClickListener() {
            @Override
            public void itemClickListener(ModelPizarra pizarra, int position) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.men,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_rateus:
                Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_aboutus:
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_ajustes:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                return true;
            case R.id.menu_salir:
                return true;
             default:
                 return super.onOptionsItemSelected(item);
        }
    }
}
