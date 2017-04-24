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

public class BMIFragment extends Fragment {
    EditText editTextHeightFeet, editTextHeightInches, editTextWeight;
    Button buttonCalculateBMI;
    TextView displayBMI;
    public BMIFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bmi, container, false);
        editTextHeightFeet = (EditText) v.findViewById(R.id.editTextHeightFt);
        editTextHeightInches = (EditText) v.findViewById(R.id.editTextHeightIn);
        editTextWeight = (EditText) v.findViewById(R.id.editTextWeight);
        displayBMI = (TextView) v.findViewById(R.id.textViewBMI);
        buttonCalculateBMI = (Button) v.findViewById(R.id.buttonCalculateBMI);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int heightFt = Integer.parseInt(editTextHeightFeet.getText().toString());
                int heightIn = Integer.parseInt(editTextHeightInches.getText().toString());
                heightFt *= 12;
                heightFt += heightIn;
                int weight = Integer.parseInt(editTextWeight.getText().toString());
                double bmi = calculateBMI(heightFt, weight);
                displayBMI.setText(String.format("%.2f",bmi));
            }
        });
        return v;
    }

    public double calculateBMI(int height, int weight){
        System.out.println("Height/Weight: " + height + " " + weight);
        double bmi=0;
        bmi = (703 * weight);
        bmi /= height;
        bmi /= height;
        System.out.println("BMI: " + bmi);
        return bmi;
    }
}
