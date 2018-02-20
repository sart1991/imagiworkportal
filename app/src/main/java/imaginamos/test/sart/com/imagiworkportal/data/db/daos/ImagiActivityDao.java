package imaginamos.test.sart.com.imagiworkportal.data.db.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

@Dao
public interface ImagiActivityDao {

    @Query("SELECT * FROM imagi_activities")
    LiveData<List<ImagiActivity>> get();

    @Query("SELECT * FROM imagi_activities WHERE id = :id")
    LiveData<ImagiActivity> get(String id);

    @Insert(onConflict = REPLACE)
    void add(ImagiActivity imagiActivity);

    @Delete
    void delete(ImagiActivity imagiActivity);

}
