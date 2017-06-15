package com.example.shourya.myapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.support.v4.app.DialogFragment;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by shourya on 28/5/17.
 */

public class secondFragment extends Fragment {

    private String[] food;
    private Spinner spinner;
    private static Button button_order;
    View myView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        final Button button = (Button)myView.findViewById(R.id.button_order);
        food = getResources().getStringArray(R.array.food_array);
        spinner = (Spinner) myView.findViewById(R.id.food_spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, food);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder;

                builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("Oder Confirmation")
                        .setMessage("Are you sure you want to confirm the order?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "Order Confirmed", Toast.LENGTH_LONG).show();
                                dialog.cancel();

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "Order Cancelled", Toast.LENGTH_LONG).show();
                                dialog.cancel();
                                // do nothing
                            }
                        });
            }
        });
   return myView;
    }
}





