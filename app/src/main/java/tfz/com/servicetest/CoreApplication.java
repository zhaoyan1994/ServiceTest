package tfz.com.servicetest;

import android.app.Application;

public class CoreApplication extends Application {

    private static CoreApplication mApplication;

    public CoreApplication() {
        super();
    }

    @Override
    public void onCreate() {
        mApplication = this;
        super.onCreate();
    }

    public static CoreApplication getmApplication(){
        return mApplication;
    }
}
