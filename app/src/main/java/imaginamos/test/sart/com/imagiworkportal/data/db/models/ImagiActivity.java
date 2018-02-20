package imaginamos.test.sart.com.imagiworkportal.data.db.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

@Entity(tableName = "imagi_activities")
public class ImagiActivity {

    @PrimaryKey
    @NonNull
    private String id = "temp";
    private String processId;
    private String process;
    private String activityId;
    private String activity;
    private String requestDate;
    private String employee;
    private String beginDate;
    private String endDate;
    private String lastVacationOn;
    private String approved;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLastVacationOn() {
        return lastVacationOn;
    }

    public void setLastVacationOn(String lastVacationOn) {
        this.lastVacationOn = lastVacationOn;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof ImagiActivity &&
                this.id.equals(((ImagiActivity)obj).id);
    }
}
