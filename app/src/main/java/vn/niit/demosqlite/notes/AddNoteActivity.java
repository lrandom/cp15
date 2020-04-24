package vn.niit.demosqlite.notes;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import vn.niit.demosqlite.R;

public class AddNoteActivity extends Activity {
    Button btnAddNote;
    EditText edtNoteContent;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBOpenHelper dbOpenHelper = new DBOpenHelper(getApplicationContext());
        this.db = dbOpenHelper.getWritableDatabase();
        setContentView(R.layout.activity_add_note);
        btnAddNote = findViewById(R.id.btnAddNote);
        edtNoteContent=findViewById(R.id.edtNoteContent);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteContent = edtNoteContent.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put("content",noteContent);
                db.insert("notes",null,contentValues);
                Toast.makeText(AddNoteActivity.this, "Add Success", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
