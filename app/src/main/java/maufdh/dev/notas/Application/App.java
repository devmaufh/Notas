package maufdh.dev.notas.Application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import maufdh.dev.notas.Sqlite.Notesdb;

public class App extends Application {
    public static SQLiteDatabase sqlInstance;

    public static SQLiteDatabase getSqlInstance() {
        return sqlInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sqlInstance = new Notesdb(getApplicationContext(),"notesdb",null,1).getWritableDatabase();

    }
}
