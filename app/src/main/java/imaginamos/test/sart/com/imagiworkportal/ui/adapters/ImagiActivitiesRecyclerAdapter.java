package imaginamos.test.sart.com.imagiworkportal.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import imaginamos.test.sart.com.imagiworkportal.R;
import imaginamos.test.sart.com.imagiworkportal.data.db.models.ImagiActivity;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

public class ImagiActivitiesRecyclerAdapter extends
        RecyclerView.Adapter<ImagiActivitiesRecyclerAdapter.ImagiActivitiesViewHolder> {

    private List<ImagiActivity> imagiActivities = new ArrayList<>();
    private ImagiActivityCardDelegate cardDelegate;
    private Context context;

    public ImagiActivitiesRecyclerAdapter(ImagiActivityCardDelegate delegate) {
        cardDelegate = delegate;
    }

    public void setImagiActivitiesList(List<ImagiActivity> imagiActivities) {
        this.imagiActivities = imagiActivities;
        notifyDataSetChanged();
    }

    @Override
    public ImagiActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_imagi_activity, parent, false);
        return new ImagiActivitiesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImagiActivitiesViewHolder holder, int position) {
        ImagiActivity imagiActivity = imagiActivities.get(position);
        String employeeName = imagiActivity.getEmployee();
        String startDate = imagiActivity.getBeginDate();
        String endDate = imagiActivity.getEndDate();
        String approved = imagiActivity.getApproved();

        holder.txtViewName.setText(employeeName);
        holder.txtViewStartDate.setText(startDate);
        holder.txtViewEndDate.setText(endDate);

        if (approved == null || TextUtils.isEmpty(approved)) {
            holder.viewApproved.setBackgroundResource(R.color._black);
        } else if (approved.toLowerCase().equals("true")) {
            holder.viewApproved.setBackgroundResource(R.color._green);
        } else {
            holder.viewApproved.setBackgroundResource(R.color._red);
        }
    }

    @Override
    public int getItemCount() {
        return imagiActivities.size();
    }

    class ImagiActivitiesViewHolder extends RecyclerView.ViewHolder {

        TextView txtViewName;
        TextView txtViewStartDate;
        TextView txtViewEndDate;
        View viewApproved;

        public ImagiActivitiesViewHolder(View itemView) {
            super(itemView);
            bindViews(itemView);
        }

        private void bindViews(View v) {
            txtViewName = v.findViewById(R.id.textView_imagiActivityCard_nameEmployee);
            txtViewStartDate = v.findViewById(R.id.textView_imagiActivityCard_startDate);
            txtViewEndDate = v.findViewById(R.id.textView_imagiActivityCard_endDate);
            viewApproved = v.findViewById(R.id.view_imagiActivityCard_approved);

            bindViewsActions();
        }

        private void bindViewsActions() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cardDelegate.onClickCard(imagiActivities.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface ImagiActivityCardDelegate {
        void onClickCard(ImagiActivity imagiActivity);
    }
}
