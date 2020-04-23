package vn.niit.demosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(@Nullable Context context) {
        super(context, "db1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS posts(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, content VARCHAR)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS category(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
