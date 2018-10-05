package com.example.vamsi.my;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UpcomingRecyclerAdapter extends RecyclerView.Adapter<UpcomingRecyclerAdapter.ViewHolder> {
     public List<UpcomingEvent> upcoming_list;
    public UpcomingRecyclerAdapter(List<UpcomingEvent> upcoming_list){
           this.upcoming_list = upcoming_list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String event_name = upcoming_list.get(i).getEvent_name();
        viewHolder.setEventNameText(event_name);

        String event_type = upcoming_list.get(i).getEvent_type();
        viewHolder.setEventType(event_type);

        String event_location = upcoming_list.get(i).getEvent_location();
        viewHolder.setEventLocation(event_location);

        String event_coordinator = upcoming_list.get(i).getEvent_coordinator();
        viewHolder.setEventCoordinator(event_coordinator);

        long milliseconds = upcoming_list.get(i).getEvent_time().getTime();
        String dateString = new SimpleDateFormat("dd/MM   HH:mm ").format(new Date(milliseconds));
        viewHolder.setEventTime(dateString);


    }

    @Override
    public int getItemCount() {
        return upcoming_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View mView;
        private TextView eventName;
        private TextView eventType;
        private TextView eventLocation;
        private TextView eventCoordinator;
        private TextView eventTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setEventNameText(String eventNameText){
            eventName = mView.findViewById(R.id.tvEventName);
            eventName.setText(eventNameText);

        }
        public void setEventType(String eventTypeText){
            eventType = mView.findViewById(R.id.tvEventType);
            eventType.setText(eventTypeText);

        }
        public void setEventLocation(String eventLocationText){
            eventLocation = mView.findViewById(R.id.tvEventLocation);
            eventLocation.setText(eventLocationText);
        }
        public void setEventCoordinator(String eventCoordinatorText){
            eventCoordinator = mView.findViewById(R.id.tvEventCoordinators);
            eventCoordinator.setText(eventCoordinatorText);
        }
        public void setEventTime(String eventTimeString){
            eventTime = mView.findViewById(R.id.tvEventTime);
            eventTime.setText(eventTimeString);

        }
    }
}
