package imaginamos.test.sart.com.imagiworkportal.ui.activities.details;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public enum ImagiActivitiesDetailsConstants {

    INTENT_EXTRA_ID("imagiActivityId");

    private String key;

    ImagiActivitiesDetailsConstants(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
