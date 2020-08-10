package com.example.sasha.finalsoftware.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.cs4531.finalsoftware.R;
import com.example.sasha.finalsoftware.model.Period;
import com.example.sasha.finalsoftware.model.Name;
import com.example.sasha.finalsoftware.model.util.CensusSearcher;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private CensusSearcher censusSearcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        censusSearcher = new CensusSearcher(this, this);
        Button searchButton = findViewById(R.id.searchBtn);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    protected void search() {
        EditText nameBox = findViewById(R.id.searchName);
        EditText minYearBox = findViewById(R.id.searchDate);
        EditText maxYearBox = findViewById(R.id.searchDate2);
        TextView searchError = findViewById(R.id.searchError);
        TextView nameDisc = findViewById(R.id.searchResultName);
        String name = nameBox.getText().toString();
        int minYear = Integer.parseInt(minYearBox.getText().toString());
        int maxYear = Integer.parseInt(maxYearBox.getText().toString());
        Period period = new Period();

        String minDate = minYearBox.getText().toString();
        String maxDate = maxYearBox.getText().toString();

        String n1 = nameBox.getText().toString();

        if (!minDate.equals("") && !maxDate.equals("") && !n1.equals("")) {
            int mDate = Integer.parseInt(minDate);
            int maDate = Integer.parseInt(maxDate);
            if (mDate < 1880 || maDate > 2008 || mDate > maDate) {    //Makes sure data is in range
                searchError.setText("Check your dates");
            } else {
                nameDisc.setText(name);
                period.setPeriodTimeFrame(Integer.parseInt(minDate), Integer.parseInt(maxDate));

                censusSearcher.searchForName(name, period);
            }
        }
        else {
            searchError.setText("The two name and date fields can not be blank");
        }
    }


    public void updateGUI(){
        TextView namesList = findViewById(R.id.searchNameList);
        namesList.setMovementMethod(new ScrollingMovementMethod());
        List<Name> listNames;

        listNames = censusSearcher.nameList;
        int listSize = listNames.size();
        for (int n = 0; n<listSize; n++) {
            namesList.append(listNames.get(n).toString());
        }

    }
}



