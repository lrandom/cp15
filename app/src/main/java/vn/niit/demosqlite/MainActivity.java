package vn.niit.demosqlite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.Console;

import vn.niit.demosqlite.demoreceiver.MyBroadCastReceiver;
import vn.niit.demosqlite.demoreceiver.MyService;

public class MainActivity extends Activity {
    Button test;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /*SQLiteDatabase db = openOrCreateDatabase("db",MODE_PRIVATE,null);

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
        db.close();


        OpenHelper openHelper = new OpenHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();

        sqLiteDatabase.rawQuery("SELECT * FROM users WHERE id = ?",new String[]{"1"});

        sqLiteDatabase.query("posts",new String[]{"id","title"},null,null,null,null,null);*/
        /*Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID, MediaStore.Images.Media.DISPLAY_NAME},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        do {
            Log.e("ID",cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media._ID))+"");
            Log.i("NAME",cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
        }while (cursor.moveToNext());
         */

        /*MyBroadCastReceiver myBroadCastReceiver = new MyBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("TEST");*/

        //nhan toan cuc
        /*registerReceiver(myBroadCastReceiver,intentFilter); */

      /*  IntentFilter i= new IntentFilter();
        i.addAction("SERVICE");
        MyReceiver myReceiver =new MyReceiver(MainActivity.this);
        registerReceiver(myReceiver,i);*/

        final Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);

        setContentView(R.layout.main_activity);
        test=(Button)findViewById(R.id.btnTest);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("TEST");
//
//                //gui toan cuc
//                sendBroadcast(intent);
//
//                //gui noi bo
//                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                //Intent intent1 = new Intent("SEND_MESSAGE");
                //intent1.putExtra("DATA","NIIT");
                //sendBroadcast(intent1);
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.idRateApp:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.main_menu);
                popupMenu.show();
            }
        });

        //nhan noi bo
        //LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(myBroadCastReceiver,intentFilter);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);



        //registerForContextMenu(test);
    }

   /* class MyReceiver extends BroadcastReceiver{
        Context c;
        public MyReceiver(Context c) {
            this.c = c;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("SERVICE")){
                Log.i("START","S");
                Toast.makeText(this.c,"SERVICE START",Toast.LENGTH_LONG).show();
            }
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idShare:
                Toast.makeText(getApplicationContext(),"CLICK SHARE",Toast.LENGTH_SHORT).show();
                break;

            case  R.id.idRateApp:
                Toast.makeText(getApplicationContext(),"CLICK RATE APP",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idShare:
                Toast.makeText(getApplicationContext(),"CLICK SHARE",Toast.LENGTH_SHORT).show();
                break;

            case  R.id.idRateApp:
                Toast.makeText(getApplicationContext(),"CLICK RATE APP",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
