package imaginamos.test.sart.com.imagiworkportal.ui.activities.details;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import imaginamos.test.sart.com.imagiworkportal.R;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.ui.activities.main.MainActivity;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = DetailsActivity.class.getSimpleName();

    private DetailsViewModel viewModel;
    private String imagiActivityId;

    private TextView txtEmployeeName, txtTypeProcess, txtRequestDate,
                     txtLastVacations, txtBeginDate, txtEndDate;

    private Button btnApprove, btnDeny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        checkIntentInfo();
        bindViews();
        initInfo();
    }

    private void checkIntentInfo() {
        Bundle bundle = getIntent().getExtras();
        String idKey = ImagiActivitiesDetailsConstants.INTENT_EXTRA_ID.getKey();
        if (bundle != null) {
            if (bundle.containsKey(idKey)) {
                imagiActivityId = bundle.getString(idKey);
            }
        }
    }

    private void bindViews() {
        txtEmployeeName = findViewById(R.id.textView_detailsActivity_employeeName);
        txtTypeProcess = findViewById(R.id.textView_detailsActivity_typeProcess);
        txtRequestDate = findViewById(R.id.textView_detailsActivity_requestDate);
        txtLastVacations = findViewById(R.id.textView_detailsActivity_lastVacations);
        txtBeginDate = findViewById(R.id.textView_detailsActivity_beginDate);
        txtEndDate = findViewById(R.id.textView_detailsActivity_endDate);
        btnApprove = findViewById(R.id.button_detailsActivity_approve);
        btnDeny = findViewById(R.id.button_detailsActivity_deny);
    }

    private void initInfo() {
        if (imagiActivityId == null) {
            gotoMainActivity();
            return;
        }
        viewModel.getLiveImagiActivity(imagiActivityId).observe(this, new Observer<ImagiActivity>() {
            @Override
            public void onChanged(@Nullable ImagiActivity imagiActivity) {
                if (imagiActivity == null) {
                    gotoMainActivity();
                    return;
                }
                Log.i(TAG, "onClickCard: name: " + imagiActivity.getEmployee()
                        + " code: " + imagiActivity.getId());
                txtEmployeeName.setText(imagiActivity.getEmployee());
                txtTypeProcess.setText(imagiActivity.getProcess());
                txtRequestDate.setText(imagiActivity.getRequestDate());
                txtLastVacations.setText(imagiActivity.getLastVacationOn());
                txtBeginDate.setText(imagiActivity.getBeginDate());
                txtEndDate.setText(imagiActivity.getEndDate());
            }
        });
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
