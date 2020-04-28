package vn.niit.demosqlite.demoreceiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService  extends Service {

    class MyBroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("GOT","Get info from activity");
            if(intent.getAction().equals("SEND_MESSAGE")){
                String data = intent.getStringExtra("DATA");
                Log.i("DATA",data);
            }
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("HI","STARTED");
        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Intent intent = new Intent("SERVICE");
        //sendBroadcast(intent);
        IntentFilter i = new IntentFilter();
        i.addAction("SEND_MESSAGE");
        registerReceiver(new MyBroadCastReceiver(),i);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
