package com.example.shourya.myapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.Toast;
//import android.app.Activity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 * Created by shourya on 28/5/17.
 */

public class firstFragment extends Fragment{
   // ListView list;

    View myView;
    private List<Mov> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private DatabaseReference myRef;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView= inflater.inflate(R.layout.first_layout, container, false);
//

       // setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Movies");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


//                finish();
//                startActivity(intent);
                // recreate();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Mov mess = postSnapshot.getValue(Mov.class);

                    movieList.add(mess);

                    // mAdapter = new MoviesAdapter(movieList);
                    recyclerView.setAdapter(mAdapter);
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //   Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//
//            }

//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
//// getFragmentManager().beginTransaction()
////                    .replace(R.id.container, LobbyFragment.newInstance()).commit()
//                FragmentManager fM = getFragmentManager();
//                fM.beginTransaction().replace(R.id.content_frame, new firstFragment()).commit();
//}
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//
////            @Override
////            public void onChildRemoved(DataSnapshot dataSnapshot) {recreate();}
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        });


        return myView;
    }

}