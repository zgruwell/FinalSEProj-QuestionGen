package com.example.sasha.finalsoftware.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.cs4531.finalsoftware.R;
import com.example.sasha.finalsoftware.model.QuestionGenerator;

public class MainActivity extends LoginActivity {
    //SignOut Button
    Button GsignOut;
    QuestionGenerator qGenerator = new QuestionGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonToCompare = findViewById(R.id.compButton);
        Button buttonToSearch = findViewById(R.id.searchButton);
        Button buttonToQuestions = findViewById(R.id.questionButton);
        Button buttonToCompetitiveQuestions = findViewById(R.id.competitive);



        buttonToCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CompareNameActivity.class));
            }
        });

        buttonToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
        buttonToQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("Generator", qGenerator);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        buttonToCompetitiveQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CompetitiveQuizActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("Generator", qGenerator);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        GsignOut = findViewById(R.id.SignOut);
        Gsignout();

    }


    public void switchToNamesListed(View myView) {
        Intent myIntent = new Intent(this, NamesListedActivity.class);
        startActivity(myIntent);
    }

    private void Gsignout(){
        mGoogleSignInClient.signOut();
        GsignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        //    startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

}
