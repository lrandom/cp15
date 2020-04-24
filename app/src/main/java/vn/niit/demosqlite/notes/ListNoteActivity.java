package vn.niit.demosqlite.notes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import vn.niit.demosqlite.R;

public class ListNoteActivity extends Activity {
    ListView lst;
    ArrayList<Note> notes = new ArrayList<>();
    Button btnAddNote;
    NoteAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);
        lst = findViewById(R.id.lst);
        DBOpenHelper dbOpenHelper =new DBOpenHelper(getApplicationContext());
        SQLiteDatabase sql = dbOpenHelper.getWritableDatabase();
        Cursor cursor =sql.query("notes",new String[]{"id","content"},null,null,null,null,null);
        if(cursor.moveToFirst()) {
            //cursor.moveToFirst();
            do {
                Log.e("TAG",cursor.getString(cursor.getColumnIndex("content")));
                notes.add(new Note(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("content"))));
            } while (cursor.moveToNext());
        }

       adapter = new NoteAdapter(getApplicationContext(),R.layout.item_note,notes);
        sql.close();
       lst.setAdapter(adapter);
       btnAddNote = findViewById(R.id.btnAddNote);
       btnAddNote.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent =new Intent(getApplicationContext(),AddNoteActivity.class);
               startActivity(intent);
           }
       });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
