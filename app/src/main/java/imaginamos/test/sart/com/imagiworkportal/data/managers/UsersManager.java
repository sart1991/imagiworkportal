package imaginamos.test.sart.com.imagiworkportal.data.managers;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.db.AppDatabase;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.User;
import imaginamos.test.sart.com.imagiworkportal.data.networking.models.UserRes;
import imaginamos.test.sart.com.imagiworkportal.data.networking.requests.RequestService;
import imaginamos.test.sart.com.imagiworkportal.data.utils.ConverterUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class UsersManager {

    private static final String TAG = UsersManager.class.getSimpleName();

    private AppDatabase mAppDatabase;
    private RequestService mRequestService;

    private static UsersManager instance;

    private UsersManager() {
        mAppDatabase = AppDatabase.get();
        mRequestService = RequestService.get();
    }

    static UsersManager get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized UsersManager getSync() {
        if (instance == null) instance = new UsersManager();
        return instance;
    }

    public void downloadAndSaveUsers() {
        mRequestService.getUsers(new Callback<List<UserRes>>() {
            @Override
            public void onResponse(Call<List<UserRes>> call, Response<List<UserRes>> response) {
                if (response.body() != null) {
                    Log.i(TAG, "onResponse: body: " + response.body());
                    asyncSaveUsers(response.body());
                }
                else {
                    Log.i(TAG, "onResponse: successful response body null");
                }
            }

            @Override
            public void onFailure(Call<List<UserRes>> call, Throwable t) {
                Log.i(TAG, "onFailure: users download error");
            }
        });
    }

    private void asyncSaveUsers(List<UserRes> userResList) {
        UserRes[] array = new UserRes[userResList.size()];
        userResList.toArray(array);
        new AsyncSaveUsers(mAppDatabase).execute(array);
    }

    public User tryLogin(User userTrying) {
        User dbUser = getDbUserFromUsernameOrEmail(userTrying);
        if (dbUser != null && userTrying.getPassword() != null) {
            if(dbUser.getPassword().equals(userTrying.getPassword())) {
                return dbUser;
            }
        }
        return null;
    }

    private User getDbUserFromUsernameOrEmail(User user) {
        if (user != null) {
            if (user.getUsername() != null) {
                return mAppDatabase.getUserDao().getWithUsername(user.getUsername());
            } else if (user.getEmail() != null) {
                return mAppDatabase.getUserDao().getWithEmail(user.getEmail());
            }
        }
        return null;
    }



    private static class AsyncSaveUsers extends AsyncTask<UserRes, Void, Void> {

        private AppDatabase mAppDatabase;

        AsyncSaveUsers(AppDatabase appDatabase) {
            mAppDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(UserRes... users) {

            if (!isValidUserResParams(users))
                throw new RuntimeException("Invalid param User...");

            for (UserRes userRes: users) {
                User user = ConverterUtil.convert(userRes);
                mAppDatabase.getUserDao().add(user);
            }

            return null;
        }

        private boolean isValidUserResParams(UserRes... users) {
            return users.length > 0 && users[0] != null;
        }
    }

}
