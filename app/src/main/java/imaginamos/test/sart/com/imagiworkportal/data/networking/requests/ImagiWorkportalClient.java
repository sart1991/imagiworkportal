package imaginamos.test.sart.com.imagiworkportal.data.networking.requests;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.networking.models.ImagiActivityRes;
import imaginamos.test.sart.com.imagiworkportal.data.networking.models.UserRes;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public interface ImagiWorkportalClient {

    @GET("users")
    Call<List<UserRes>> getUsers();

    @GET("activities")
    Call<List<ImagiActivityRes>> getActivities();

}
