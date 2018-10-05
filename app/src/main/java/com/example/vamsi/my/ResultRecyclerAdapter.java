package com.example.vamsi.my;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ResultRecyclerAdapter extends RecyclerView.Adapter<ResultRecyclerAdapter.ViewHolder> {
    public List<ResultEvent> results_list;

    public ResultRecyclerAdapter(List<ResultEvent> results_list){
        this.results_list = results_list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String event_name = results_list.get(i).getEvent_name();
        viewHolder.setEventNameResult(event_name);

        String event_type =results_list.get(i).getEvent_type();
        viewHolder.setEventTypeResult(event_type);

        String first_winner = results_list.get(i).getFirst_winner();
        viewHolder.setFirstWinner(first_winner);

        String second_winner = results_list.get(i).getSecond_winner();
        viewHolder.setSecondWinner(second_winner);

    }

    @Override
    public int getItemCount() {
        return results_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View mview;
        private TextView eventName;
        private TextView eventType;
        private TextView firstWinner;
        private TextView secondWinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
        }
        public void setEventNameResult(String eventNameResult){
            eventName = mview.findViewById(R.id.tvEventNameResult);
            eventName.setText(eventNameResult);
        }
        public void setEventTypeResult(String eventTypeResult){
            eventType = mview.findViewById(R.id.tvEventTypeResult);
            eventType.setText(eventTypeResult);
        }
        public void setFirstWinner(String eventFirstWinner){
            firstWinner = mview.findViewById(R.id.tvEventWinnerFirstName);
            firstWinner.setText("First : "+ eventFirstWinner);
        }

        public void setSecondWinner(String second_winner) {
            secondWinner = mview.findViewById(R.id.tvEventWinnerSecondName);
            secondWinner.setText("Second : "+second_winner);
        }
    }
}
