package imaginamos.test.sart.com.imagiworkportal.ui.activities.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.data.managers.DataManager;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class MainViewModel extends ViewModel {

    private DataManager mDataManager;

    public MainViewModel() {
        mDataManager = DataManager.get();
        initialDownload();
    }

    public boolean isLoggedIn() {
        return mDataManager.getPreferencesManager().getLoginStatus();
    }

    public LiveData<List<ImagiActivity>> getLiveImagiActivities() {
        return mDataManager.getImagiActivitiesManager().getLiveImagiActivities();
    }

    private void initialDownload() {
        mDataManager.getUsersManager().downloadAndSaveUsers();
        mDataManager.getImagiActivitiesManager().downloadAndSaveImagiActivities();
    }
}
