package imaginamos.test.sart.com.imagiworkportal.data.networking.requests;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.data.networking.models.ImagiActivityRes;
import imaginamos.test.sart.com.imagiworkportal.data.networking.models.UserRes;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class RequestService {

    private static final String BASE_URL = "http://026a63b0.ngrok.io/";

    private OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();

    private Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private Retrofit retrofit = retrofitBuilder.client(httpBuilder.build()).build();

    private ImagiWorkportalClient imagiWorkportalClient =
            retrofit.create(ImagiWorkportalClient.class);

    private static RequestService instance;

    private RequestService() {}

    public static RequestService get() {
        if (instance == null) instance = getSync();
        return instance;
    }

    private static synchronized RequestService getSync() {
        if (instance == null) instance = new RequestService();
        return instance;
    }

    public void getUsers(Callback<List<UserRes>> usersCallback) {
        Call<List<UserRes>> call = imagiWorkportalClient.getUsers();
        enqueueRequests(call, usersCallback);
    }

    public void getActivities(Callback<List<ImagiActivityRes>> activitiesCallback) {
        Call<List<ImagiActivityRes>> call = imagiWorkportalClient.getActivities();
        enqueueRequests(call, activitiesCallback);
    }

    private <T> void enqueueRequests(Call<T> call, Callback<T> callback) {
        call.enqueue(callback);
    }

}
