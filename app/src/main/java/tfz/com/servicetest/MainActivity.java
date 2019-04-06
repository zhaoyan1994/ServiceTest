package tfz.com.servicetest;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private TimeClockReceiver timeClockReceiver;
    private Handler threadHandlerB;

    private Handler handlerMain = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Looper looper = Looper.getMainLooper();
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    //
    private void init() {
        //启动service
//        Intent serviceIntent = new Intent(MainActivity.this, TargetService.class);
//        startService(serviceIntent);

//        timeClockReceiver = new TimeClockReceiver(this);
//        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);
//        registerReceiver(timeClockReceiver, intentFilter);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper looper = Looper.getMainLooper();
                Looper.prepare();
                threadHandlerB = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                    }
                };
                Looper.loop();
            }
        });
        threadB.start();;

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadHandlerB.sendEmptyMessage(0);
                handlerMain.sendEmptyMessage(0);
            }
        });
        threadA.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
//        if (timeClockReceiver != null) {
//            unregisterReceiver(timeClockReceiver);
//        }
        super.onDestroy();
    }
}
