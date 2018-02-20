package imaginamos.test.sart.com.imagiworkportal.data.preferences;

/**
 * Created by SergioAlejandro on 29/11/2017.
 */

public enum PreferencesKeys {

    LOGGED_IN("loggedIn"), FIRST_DOWNLOAD("firstDownload");

    private String value;

    PreferencesKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
