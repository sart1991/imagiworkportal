package imaginamos.test.sart.com.imagiworkportal.data.preferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import imaginamos.test.sart.com.imagiworkportal.App;


/**
 * Created by SergioAlejandro on 29/11/2017.
 */

public class AppPreferences {

    private static AppPreferences instance = new AppPreferences();
    private SharedPreferences preferences;

    private AppPreferences() {
        preferences = PreferenceManager.getDefaultSharedPreferences(App.get());
    }

    public static AppPreferences get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized AppPreferences getSync() {
        if (instance == null) instance = new AppPreferences();
        return instance;
    }

    public void addPreference(PreferencesKeys key, String value) {
        instance.preferences.edit().putString(key.getValue(), value).apply();
    }

    public void addPreference(PreferencesKeys key, boolean value) {
        instance.preferences.edit().putBoolean(key.getValue(), value).apply();
    }

    public boolean getPreference(PreferencesKeys key, boolean defValue) {
        return preferences.getBoolean(key.getValue(), defValue);
    }
}
