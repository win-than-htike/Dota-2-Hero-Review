package xyz.winthanhtike.travelandtour;

import android.app.Application;
import android.content.Context;

/**
 * Created by winthanhtike on 6/27/16.
 */
public class Dota2HeroApp extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        context = null;

    }

    public static Context getContext() {
        return context;
    }
}
