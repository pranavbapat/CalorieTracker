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

public class LookupFoodFragment extends Fragment {
    EditText editTextLookupFood;
    Button lookupFood;

    public LookupFoodFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lookup_food, container, false);
        editTextLookupFood = (EditText) v.findViewById(R.id.editTextLookupFood);

        lookupFood = (Button) v.findViewById(R.id.buttonLookupFoodItem);
        lookupFood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            String lookupFoodItem = editTextLookupFood.getText().toString();
                if(!lookupFoodItem.equals("")){
                    getFoodFromAPI(lookupFoodItem);
                }
            }
        });
        return v;
    }

    public void getFoodFromAPI(String lookupFoodItem){

    }
}
