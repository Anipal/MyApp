package com.example.shourya.myapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by shourya on 28/5/17.
 */

public class firstFragment extends Fragment{

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView= inflater.inflate(R.layout.first_layout, container, false);
        String [] menu={"Up",
        "Despicable Me",
        "Finding Nemo"};
        ListView listview=(ListView)myView.findViewById(R.id.list);
        ArrayAdapter<String>listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menu
        );
        listview.setAdapter(listViewAdapter);
        return myView;
    }

}
