package maufdh.dev.notas.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Notesdb extends SQLiteOpenHelper {
    public Notesdb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    String createPizzarra="create table pizarra(id_pizarra integer auto_increment primary key, name text not null, description text, color integer)";
    String createNotes="create table notes(id_note integer auto_increment primary key ,name text not null, content text, color integer)";
    String createFavorites="create table favorites(id_favorite integer auto_increment primary key,id_note integer not null, foreign key(id_note) references notes(id_note))";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createPizzarra);
        db.execSQL(createNotes);
        db.execSQL(createFavorites);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+createPizzarra);
        db.execSQL("DROP TABLE IF EXISTS "+createNotes);
        db.execSQL("DROP TABLE IF EXISTS "+createFavorites);
    }
}
