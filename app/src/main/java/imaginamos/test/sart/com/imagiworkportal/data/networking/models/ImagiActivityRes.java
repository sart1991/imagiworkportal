package imaginamos.test.sart.com.imagiworkportal.data.networking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class ImagiActivityRes {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("processId")
    @Expose
    private String processId;
    @SerializedName("process")
    @Expose
    private String process;
    @SerializedName("activityId")
    @Expose
    private String activityId;
    @SerializedName("activity")
    @Expose
    private String activity;
    @SerializedName("requestDate")
    @Expose
    private String requestDate;
    @SerializedName("employee")
    @Expose
    private String employee;
    @SerializedName("beginDate")
    @Expose
    private String beginDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("lastVacationOn")
    @Expose
    private String lastVacationOn;
    @SerializedName("approved")
    @Expose
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

}
