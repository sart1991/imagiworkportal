package imaginamos.test.sart.com.imagiworkportal.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import imaginamos.test.sart.com.imagiworkportal.App;
import imaginamos.test.sart.com.imagiworkportal.data.db.daos.ImagiActivityDao;
import imaginamos.test.sart.com.imagiworkportal.data.db.daos.UserDao;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.User;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

@Database(entities = {User.class, ImagiActivity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "db_imagi_workportal";

    private static AppDatabase instance;

    public static AppDatabase get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized AppDatabase getSync() {
        if (instance == null) {
            instance = Room.databaseBuilder(App.get(), AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract UserDao getUserDao();

    public abstract ImagiActivityDao getImagiActivityDao();
}
