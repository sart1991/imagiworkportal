package imaginamos.test.sart.com.imagiworkportal.data.db.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.db.models.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    LiveData<List<User>> get();

    @Query("SELECT * FROM users WHERE id = :id")
    LiveData<User> getWithId(String id);

    @Query("SELECT * FROM users WHERE username = :username")
    User getWithUsername(String username);

    @Query("SELECT * FROM users WHERE email = :email")
    User getWithEmail(String email);

    @Insert(onConflict = REPLACE)
    void add(User user);

    @Delete
    void delete(User user);
}
