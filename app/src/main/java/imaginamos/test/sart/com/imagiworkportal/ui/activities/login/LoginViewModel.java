package imaginamos.test.sart.com.imagiworkportal.ui.activities.login;

import android.arch.lifecycle.ViewModel;

import imaginamos.test.sart.com.imagiworkportal.data.db.models.User;
import imaginamos.test.sart.com.imagiworkportal.data.managers.DataManager;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class LoginViewModel extends ViewModel {

    private DataManager mDataManager;
    private User dbUser;

    public LoginViewModel() {
        mDataManager = DataManager.get();
    }

    public boolean attemptSuccessfulLogin(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        dbUser = mDataManager.getUsersManager().tryLogin(user);
        if (dbUser != null) {
            mDataManager.getPreferencesManager().login();
            return dbUser != null;
        }
        return false;
    }

    public User getLoggedUser() {
        return dbUser;
    }
}
