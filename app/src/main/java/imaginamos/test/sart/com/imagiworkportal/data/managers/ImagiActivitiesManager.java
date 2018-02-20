package imaginamos.test.sart.com.imagiworkportal.data.managers;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.db.AppDatabase;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.data.networking.models.ImagiActivityRes;
import imaginamos.test.sart.com.imagiworkportal.data.networking.requests.RequestService;
import imaginamos.test.sart.com.imagiworkportal.data.utils.ConverterUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class ImagiActivitiesManager {

    private static final String TAG = ImagiActivitiesManager.class.getSimpleName();

    private AppDatabase mAppDatabase;
    private RequestService mRequestService;

    private static ImagiActivitiesManager instance;

    private ImagiActivitiesManager() {
        mAppDatabase = AppDatabase.get();
        mRequestService = RequestService.get();
    }

    static ImagiActivitiesManager get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized ImagiActivitiesManager getSync() {
        if (instance == null) instance = new ImagiActivitiesManager();
        return instance;
    }

    public void downloadAndSaveImagiActivities() {
        mRequestService.getActivities(new Callback<List<ImagiActivityRes>>() {
            @Override
            public void onResponse(Call<List<ImagiActivityRes>> call,
                                   Response<List<ImagiActivityRes>> response) {
                if (response.body() != null) {
                    Log.i(TAG, "onResponse: body: " + response.body());
                    asyncSaveImagiActivities(response.body());
                } else {
                    Log.i(TAG, "onResponse: successful response with null body");
                }

            }

            @Override
            public void onFailure(Call<List<ImagiActivityRes>> call, Throwable t) {
                Log.i(TAG, "onFailure: request failed");
            }
        });
    }

    private void asyncSaveImagiActivities(List<ImagiActivityRes> imagiActivityResList) {
        ImagiActivityRes[] array = new ImagiActivityRes[imagiActivityResList.size()];
        imagiActivityResList.toArray(array);
        new AsyncSaveImagiActivities(mAppDatabase).execute(array);
    }

    public LiveData<List<ImagiActivity>> getLiveImagiActivities() {
        return mAppDatabase.getImagiActivityDao().get();
    }

    public LiveData<ImagiActivity> getLiveImagiActivity(String id) {
        return mAppDatabase.getImagiActivityDao().get(id);
    }

    private static class AsyncSaveImagiActivities extends AsyncTask<ImagiActivityRes, Void, Void> {

        private AppDatabase mAppDatabase;

        AsyncSaveImagiActivities(AppDatabase appDatabase) {
            mAppDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(ImagiActivityRes... imagiActivities) {

            if (!isValidImagiActivitiesResParams(imagiActivities))
                throw new RuntimeException("Invalid param ImagiActivityRes...");

            for (ImagiActivityRes imagiActivityRes: imagiActivities) {
                ImagiActivity imagiActivity = ConverterUtil.convert(imagiActivityRes);
                mAppDatabase.getImagiActivityDao().add(imagiActivity);
            }

            return null;
        }

        private boolean isValidImagiActivitiesResParams(ImagiActivityRes... imagiActivityRes) {
            return imagiActivityRes.length > 0 && imagiActivityRes[0] != null;
        }
    }
}
