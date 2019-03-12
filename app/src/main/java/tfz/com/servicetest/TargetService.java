package tfz.com.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;

public class TargetService extends Service {

    private static final String TAG = "TargetService";
    private int mCount = 0;
    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCount++;
            if(mCount == 3){
                //每隔3分钟震动1000毫秒
                Vibrator vibrator=(Vibrator)getSystemService(Service.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
                mCount = 0;
            }
            mhandler.sendEmptyMessageDelayed(0,60*1000);
        }
    };

    public TargetService() {
        super();
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate()");
        mhandler.sendEmptyMessageDelayed(0,60*1000);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind()");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy()");
        Log.e(TAG, "heart Rate" + mCount);
        super.onDestroy();
    }
}
