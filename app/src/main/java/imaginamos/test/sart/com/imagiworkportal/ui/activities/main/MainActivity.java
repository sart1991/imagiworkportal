package imaginamos.test.sart.com.imagiworkportal.ui.activities.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.R;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.ui.activities.BaseActivity;
import imaginamos.test.sart.com.imagiworkportal.ui.activities.login.LoginActivity;
import imaginamos.test.sart.com.imagiworkportal.ui.adapters.ImagiActivitiesRecyclerAdapter;

public class MainActivity extends BaseActivity
        implements ImagiActivitiesRecyclerAdapter.ImagiActivityCardDelegate {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private ImagiActivitiesRecyclerAdapter imagiActivitiesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (!viewModel.isLoggedIn()) {
            gotoLoginActivity();
        }
        bindViews();
        configViews();
        initInformation();
    }

    private void bindViews() {
        recyclerView = findViewById(R.id.recyclerView_mainActivity_imagiActivities);
    }

    private void configViews() {
        LinearLayoutManager llm = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false
        );
        recyclerView.setLayoutManager(llm);
        imagiActivitiesRecyclerAdapter = new ImagiActivitiesRecyclerAdapter(this);
        recyclerView.setAdapter(imagiActivitiesRecyclerAdapter);
    }

    private void initInformation() {
        viewModel.getLiveImagiActivities().observe(this, new Observer<List<ImagiActivity>>() {
            @Override
            public void onChanged(@Nullable List<ImagiActivity> imagiActivities) {
                if (imagiActivities == null) {
                    Log.i(TAG, "onChanged: imagiActivities == null");
                    return;
                }
                imagiActivitiesRecyclerAdapter.setImagiActivitiesList(imagiActivities);
            }
        });
    }

    private void gotoLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClickCard(ImagiActivity imagiActivity) {
        Log.i(TAG, "onClickCard: name: " + imagiActivity.getEmployee()
                + " code: " + imagiActivity.getId());
    }
}
