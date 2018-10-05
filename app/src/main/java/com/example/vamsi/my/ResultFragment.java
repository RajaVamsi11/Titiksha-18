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
public class ResultFragment extends Fragment {
    private RecyclerView result_recycler_view;
    private List<ResultEvent> results_list;
    private FirebaseFirestore firebaseFirestore;

    private ResultRecyclerAdapter resultRecyclerAdapter;


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        // Inflate the layout for this fragment
        results_list = new ArrayList<>();
        result_recycler_view = view.findViewById(R.id.result_recycler_view);
        firebaseFirestore = FirebaseFirestore.getInstance();
        resultRecyclerAdapter = new ResultRecyclerAdapter(results_list);

        result_recycler_view.setLayoutManager(new LinearLayoutManager(container.getContext()));
        result_recycler_view.setAdapter(resultRecyclerAdapter);
        firebaseFirestore.collection("results").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                for(DocumentChange doc:documentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){

                        ResultEvent resultEvent = doc.getDocument().toObject(ResultEvent.class);
                        results_list.add(resultEvent);
                        resultRecyclerAdapter.notifyDataSetChanged();

                    }
                }

            }
        });

        return view;
    }

}
