package com.omkokate.attendanceupload;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.grid_layout); // get the GridLayout view
        int numRows = 10;
        int numCols = 5;
        int buttonCount = 1;

// Create an array to store the checked checkboxes
        final ArrayList<Integer> checkedBoxes = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                final CheckBox cb = new CheckBox(this);
                cb.setText("" + buttonCount);
                buttonCount++;

                // Add an OnCheckedChangeListener to the checkbox
                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        // If the checkbox is checked, add its value to the list
                        // Otherwise, remove its value from the list (if it was already in the list)
                        int value = Integer.parseInt(cb.getText().toString());
                        if (isChecked) {
                            checkedBoxes.add(value);
                        } else {
                            checkedBoxes.remove((Integer) value);
                        }
                    }
                });

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(row);
                params.columnSpec = GridLayout.spec(col);
                gridLayout.addView(cb, params);
            }
        }

// Get the button view
        Button printButton = findViewById(R.id.btn);
        TextView tv= findViewById(R.id.tv);

// Add an OnClickListener to the button to print the checked boxes
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Print the values of the checked checkboxes
                Log.d("Checked Boxes", "Values: " + checkedBoxes.toString());
                tv.setText(checkedBoxes.toString());
            }
        });


    }
}