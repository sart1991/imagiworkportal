package imaginamos.test.sart.com.imagiworkportal.data.managers;

import android.preference.PreferenceManager;

import imaginamos.test.sart.com.imagiworkportal.data.preferences.AppPreferences;
import imaginamos.test.sart.com.imagiworkportal.data.preferences.PreferencesKeys;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class PreferencesManager {

    private AppPreferences mAppPreferences;

    private static PreferencesManager instance;

    private PreferencesManager() {
        mAppPreferences = AppPreferences.get();
    }

    public static PreferencesManager get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized PreferencesManager getSync() {
        if (instance == null) instance = new PreferencesManager();
        return instance;
    }

    public void login() {
        modifyLoginStatus(true);
    }

    public void logout() {
        modifyLoginStatus(false);
    }

    public boolean getLoginStatus() {
        return mAppPreferences.getPreference(PreferencesKeys.LOGGED_IN, false);
    }

    private void modifyLoginStatus(boolean status) {
        mAppPreferences.addPreference(PreferencesKeys.LOGGED_IN, status);
    }

}
