package imaginamos.test.sart.com.imagiworkportal.ui.activities.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;

import imaginamos.test.sart.com.imagiworkportal.R;
import imaginamos.test.sart.com.imagiworkportal.ui.activities.BaseActivity;
import imaginamos.test.sart.com.imagiworkportal.ui.activities.login.LoginActivity;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (!viewModel.isLoggedIn()) {
            gotoLoginActivity();
        }
    }

    private void gotoLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
