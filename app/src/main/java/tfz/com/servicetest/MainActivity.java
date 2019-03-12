package tfz.com.servicetest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private boolean isFroground = false;
    private TimeClockReceiver timeClockReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    //
    private void init() {
        //启动service
        Intent serviceIntent = new Intent(MainActivity.this, TargetService.class);
        startService(serviceIntent);

        timeClockReceiver = new TimeClockReceiver(this);
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);
        registerReceiver(timeClockReceiver, intentFilter);
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
        isFroground = true;
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        isFroground = false;
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (timeClockReceiver != null) {
            unregisterReceiver(timeClockReceiver);
        }
        super.onDestroy();
    }

    public boolean getActivityIsForground(){
        return isFroground;
    }
}
