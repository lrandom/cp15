package vn.niit.demosqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* SQLiteDatabase db = openOrCreateDatabase("db",MODE_PRIVATE,null);

        String sql = "CREATE TABLE IF NOT EXISTS users(id INTERGER PRIMARY KEY AUTOINCREMENT, fullname varchar, username varchar, pwd varchar)";
        db.execSQL(sql);

        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname","Luan");
        contentValues.put("username","lrandom");
        contentValues.put("pwd","admin");
        db.insertOrThrow("users","", contentValues);

        Cursor cursor= db.query("users",new String[]{"id","fullname","username","pwd"},
                "",null,null,null,null);
        if(cursor!=null) {
            cursor.moveToFirst();
        }
        do {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String fullname = cursor.getString(cursor.getColumnIndex("fullname"));
            String username = cursor.getString(cursor.getColumnIndex("username"));

            Log.i("INFO","id="+id+"&fullname="+fullname+"&username="+username);
        }while (cursor.moveToNext());
        db.close();*/


        OpenHelper openHelper = new OpenHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();

        sqLiteDatabase.rawQuery("SELECT * FROM users WHERE id = ?",new String[]{"1"});

        sqLiteDatabase.query("posts",new String[]{"id","title"},null,null,null,null,null);
    }
}
