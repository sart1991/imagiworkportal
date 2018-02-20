package imaginamos.test.sart.com.imagiworkportal.data.managers;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class DataManager {

    private UsersManager mUsersManager;
    private ImagiActivitiesManager mImagiActivitiesManager;
    private PreferencesManager mPreferencesManager;

    private static DataManager instance;

    private DataManager() {
        mUsersManager = UsersManager.get();
        mImagiActivitiesManager = ImagiActivitiesManager.get();
        mPreferencesManager = PreferencesManager.get();
    }

    public static DataManager get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized DataManager getSync() {
        if (instance == null) instance = new DataManager();
        return instance;
    }

    public UsersManager getUsersManager() {
        return mUsersManager;
    }

    public ImagiActivitiesManager getImagiActivitiesManager() {
        return mImagiActivitiesManager;
    }

    public PreferencesManager getPreferencesManager() {
        return mPreferencesManager;
    }


}
