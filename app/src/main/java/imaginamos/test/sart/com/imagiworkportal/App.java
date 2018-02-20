package imaginamos.test.sart.com.imagiworkportal;

import android.app.Application;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App get() {
        return instance;
    }
}
