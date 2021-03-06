package imaginamos.test.sart.com.imagiworkportal.ui.activities.details;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.data.managers.DataManager;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class DetailsViewModel extends ViewModel {

    private DataManager mDataManager;

    public DetailsViewModel() {
        mDataManager = DataManager.get();
    }

    public LiveData<ImagiActivity> getLiveImagiActivity(String id) {
        return mDataManager.getImagiActivitiesManager().getLiveImagiActivity(id);
    }

    public void updateimagiActivity(ImagiActivity imagiActivity) {
        mDataManager.getImagiActivitiesManager().insertImagiActivity(imagiActivity);
    }
}
