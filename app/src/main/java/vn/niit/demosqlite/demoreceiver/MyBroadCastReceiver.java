package vn.niit.demosqlite.demoreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Lenh xu li khi co tin hieu gui den hay khi nhan duoc tin hieu
//        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
//            Log.i("RECEIVE","Da nhan duoc tin hieu bat tat che do may bay");
//        }


        String action = intent.getAction();
        Log.i("TEST",action);
        switch (action){
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                //xu li tin hieu bat tat che do maybay
                break;
            case  "TEST":
                //xu li tin hieu khi nhan duoc test
                break;

            case "SERVICE":
                Log.i("SERVICE","HI");
                break;
        }
    }
}
