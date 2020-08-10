package com.example.sasha.finalsoftware.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.cs4531.finalsoftware.R;
import com.example.sasha.finalsoftware.model.Name;
import com.example.sasha.finalsoftware.model.Period;
import com.example.sasha.finalsoftware.model.util.CensusSearcher;
import org.w3c.dom.Text;

import java.util.List;

public class CompareNameActivity extends AppCompatActivity {

    private CensusSearcher name1Search;
    private CensusSearcher name2Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        name1Search = new CensusSearcher(this, this);
        name2Search = new CensusSearcher(this, this);

        Button compareBtn = findViewById(R.id.compareBtn);
        compareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView namePercentDiff = findViewById(R.id.compareNamePercentDiff);
                TextView name1disc = findViewById(R.id.compareResultName1disc);
                TextView name2disc = findViewById(R.id.compareResultName2disc);
                EditText mindate = findViewById(R.id.compareDate1);
                EditText maxdate = findViewById(R.id.compareDate2);
                EditText name1 = findViewById(R.id.compareName);
                EditText name2 = findViewById(R.id.compareName1);

                List listName1;
                List listName2;
                Period timeP = new Period();

                String minDate = mindate.getText().toString();
                String maxDate = maxdate.getText().toString();

                String n1 = name1.getText().toString();
                String n2 = name2.getText().toString();

                if (!minDate.equals("") && !maxDate.equals("") && !n1.equals("") && !n2.equals("")) {      //Makes sure there is no blank fields
                    int mDate = Integer.parseInt(minDate);
                    int maDate = Integer.parseInt(maxDate);
                    if (mDate < 1880 || maDate > 2008 || mDate > maDate) {    //Makes sure data is in range
                        namePercentDiff.setText("Check your dates");
                    } else {
                        name1disc.setText(n1);
                        name2disc.setText(n2);
                        timeP.setPeriodTimeFrame(Integer.parseInt(minDate), Integer.parseInt(maxDate));

                        name1Search.searchForName(n1, timeP);
                        name2Search.searchForName(n2, timeP);
                    }
                }
                else {
                    namePercentDiff.setText("The two name and date fields can not be blank");
                }
            }
        });
    }

    public void updateGUI(){
        TextView nameList1 = findViewById(R.id.compareNameList1);
        nameList1.setMovementMethod(new ScrollingMovementMethod());
        List<Name> listName1;

        TextView nameList2 = findViewById(R.id.compareNameList2);
        nameList2.setMovementMethod(new ScrollingMovementMethod());
        List<Name> listName2;


        listName1 = name1Search.nameList;
        int list1Size = listName1.size();
        for (int n = 0; n<list1Size; n++) {
            nameList1.append(listName1.get(n).toString());
        }

        listName2 = name2Search.nameList;
        int list2Size = listName2.size();
        for (int n = 0; n<list2Size; n++){
            nameList2.append(listName2.get(n).toString());
        }


    }






}
