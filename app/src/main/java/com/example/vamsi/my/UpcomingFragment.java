package com.example.vamsi.my;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    private RecyclerView upcoming_view;
    private List<UpcomingEvent> upcoming_list;
    private FirebaseFirestore firebaseFirestore;
    private UpcomingRecyclerAdapter upcomingRecyclerAdapter;



    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        upcoming_list =  new ArrayList<>();

        upcoming_view = view.findViewById(R.id.upcoming_view);
        upcomingRecyclerAdapter = new UpcomingRecyclerAdapter(upcoming_list);
        // Inflate the layout for this fragment

        upcoming_view.setLayoutManager(new LinearLayoutManager(container.getContext()));
        upcoming_view.setAdapter(upcomingRecyclerAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("events").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                for(DocumentChange doc:documentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        UpcomingEvent upcomingEvent = doc.getDocument().toObject(UpcomingEvent.class);
                        upcoming_list.add(upcomingEvent);
                        upcomingRecyclerAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
        return view;
    }

}
