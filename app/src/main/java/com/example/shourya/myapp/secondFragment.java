package com.example.shourya.myapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shourya on 28/5/17.
 */

public class secondFragment extends Fragment{

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView= inflater.inflate(R.layout.second_layout, container, false);
        return myView;
    }

}