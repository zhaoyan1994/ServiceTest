package tfz.com.servicetest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class TimeClockReceiver extends BroadcastReceiver {

    private int clockCount = 0 ;

    public TimeClockReceiver() {
        super();
    }

    public TimeClockReceiver(Context context) {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        clockCount++;

        if(clockCount == 1){
            Intent callIntent = new Intent(CoreApplication.getmApplication(), CallActivity.class);
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            CoreApplication.getmApplication().startActivity(callIntent);
            Log.e("TargetService-Main","Time Clock!");
            clockCount = 0;
        }
    }
}