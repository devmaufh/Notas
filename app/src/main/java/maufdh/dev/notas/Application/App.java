package maufdh.dev.notas.Application;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import maufdh.dev.notas.Activities.CodeActivity;
import maufdh.dev.notas.Activities.MainActivity;
import maufdh.dev.notas.Sqlite.Notesdb;

public class App extends Application {
    public static SQLiteDatabase sqlInstance;
    public static SharedPreferences prefs;
    public static SQLiteDatabase getSqlInstance() {
        return sqlInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        prefs=getApplicationContext().getSharedPreferences("prefs",MODE_PRIVATE);
        sqlInstance = new Notesdb(getApplicationContext(),"notesdb",null,1).getWritableDatabase();
        Toast.makeText(this, "ONCREATE APP", Toast.LENGTH_SHORT).show();


        if(!checkIfCodeExists()){ //Quitar negacion ---solo fue un test
            //redirect to code
            Toast.makeText(this, "CODEACTIVITY", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }else{
            Toast.makeText(this, "MAIN", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(getApplicationContext(), CodeActivity.class));
        }
    }
    public boolean checkIfCodeExists(){
        return prefs.getString("code","null").equals("null");
    }
}
