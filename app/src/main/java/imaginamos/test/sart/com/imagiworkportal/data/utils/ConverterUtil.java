package imaginamos.test.sart.com.imagiworkportal.data.utils;

import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.User;
import imaginamos.test.sart.com.imagiworkportal.data.networking.models.ImagiActivityRes;
import imaginamos.test.sart.com.imagiworkportal.data.networking.models.UserRes;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class ConverterUtil {

    private ConverterUtil() {}

    public static User convert(UserRes userRes) {
        User user = new User();
        user.setId(userRes.getId());
        user.setEmail(userRes.getEmail());
        user.setName(userRes.getName());
        user.setPassword(userRes.getPassword());
        user.setUsername(userRes.getUsername());
        return user;
    }

    public static ImagiActivity convert(ImagiActivityRes imagiActivityRes) {
        ImagiActivity imagiActivity = new ImagiActivity();
        imagiActivity.setId(imagiActivityRes.getId());
        imagiActivity.setActivity(imagiActivityRes.getActivity());
        imagiActivity.setActivityId(imagiActivityRes.getActivityId());
        imagiActivity.setApproved(imagiActivityRes.getApproved());
        imagiActivity.setBeginDate(imagiActivityRes.getBeginDate());
        imagiActivity.setEmployee(imagiActivityRes.getEmployee());
        imagiActivity.setEndDate(imagiActivityRes.getEndDate());
        imagiActivity.setLastVacationOn(imagiActivityRes.getLastVacationOn());
        imagiActivity.setProcess(imagiActivityRes.getProcess());
        imagiActivity.setProcessId(imagiActivityRes.getProcessId());
        imagiActivity.setRequestDate(imagiActivityRes.getRequestDate());
        return imagiActivity;
    }

}
