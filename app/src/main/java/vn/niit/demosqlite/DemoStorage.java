package vn.niit.demosqlite;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;

public class DemoStorage extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ghi file
        /*try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            fos.write("hi CP15".getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //đọc file
        /*try{
            FileInputStream fos = openFileInput("test.txt");
            int data=0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((data=fos.read())!=-1){
                stringBuilder.append((char)data);
            }
            Log.i("HELLO",stringBuilder.toString());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //demo raw
         /*InputStream fis = getApplicationContext().getResources().openRawResource(R.raw.test);
         try {
             int data=0;
             StringBuilder stringBuilder = new StringBuilder();
             while ((data=fis.read())!=-1){
                 stringBuilder.append((char)data);
             }
             Log.i("HELLO",stringBuilder.toString());
         }catch (Exception e){
             e.printStackTrace();
         }*/

         if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
             //tien hanh doc ghi
             /*try {
                 FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory()+"/Download/test.txt");
                 fileOutputStream.write("Say hi".getBytes());
                 fileOutputStream.close();
             }catch (Exception e){
                 e.printStackTrace();
             }*/

             try {
                 FileInputStream fileInputStream = new FileInputStream(Environment.getExternalStorageDirectory()+"/Download/test.txt");
                 try {
                     int data=0;
                     StringBuilder stringBuilder = new StringBuilder();
                     while ((data=fileInputStream.read())!=-1){
                         stringBuilder.append((char)data);
                     }
                     Log.i("HELLO",stringBuilder.toString());
                 }catch (Exception e){
                     e.printStackTrace();
                 }
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
    }
}
