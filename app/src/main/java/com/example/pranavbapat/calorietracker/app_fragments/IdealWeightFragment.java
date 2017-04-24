package com.example.pranavbapat.calorietracker.app_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pranavbapat.calorietracker.R;

/**
 * Created by pranav.bapat on 4/23/17.
 */

public class IdealWeightFragment extends Fragment {
    EditText editTextHeightFeet, editTextHeightInches;
    Button buttonCalculateIdealWeight;
    TextView displayIdealWeight;
    public IdealWeightFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ideal_weight, container, false);
        editTextHeightFeet = (EditText) v.findViewById(R.id.editTextHeightFt);
        editTextHeightInches = (EditText) v.findViewById(R.id.editTextHeightIn);
        displayIdealWeight = (TextView) v.findViewById(R.id.textViewIdealWeight);
        buttonCalculateIdealWeight = (Button) v.findViewById(R.id.buttonCalculateIdealWeight);

        buttonCalculateIdealWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int heightFt = Integer.parseInt(editTextHeightFeet.getText().toString());
                int heightIn = Integer.parseInt(editTextHeightInches.getText().toString());
                heightIn += (12 * heightFt);
                double idealWeight = calculateIdealWeight(heightIn);
                displayIdealWeight.setText(String.format("%.2f lbs",idealWeight));
            }
        });
        return v;
    }

    public double calculateIdealWeight(int height){
        System.out.println("Height " + height + " ");
        height = height - 60;
        double idealWeight = (1.41 * height) + 50;
        idealWeight *= 2.2;
        System.out.println("Ideal Weight: " + idealWeight);
        return idealWeight;
    }
}
