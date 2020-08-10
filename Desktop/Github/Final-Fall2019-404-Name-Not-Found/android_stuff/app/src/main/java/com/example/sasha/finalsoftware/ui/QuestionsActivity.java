package com.example.sasha.finalsoftware.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.Random;
import com.example.cs4531.finalsoftware.R;
import com.example.sasha.finalsoftware.model.Question;
import com.example.sasha.finalsoftware.model.QuestionGenerator;
import com.example.sasha.finalsoftware.ui.RestSingleton;
public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener{
    Question question;
    private TextView resultBox;
    private TextView QuestionBox;
    private int score = 0;
    private int numberofQuestions = 0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button ViewResultButton;
    Button Quitbutton;
    private String answer;
    private QuestionGenerator qGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ViewResultButton = findViewById(R.id.ResultButton);
        ViewResultButton.setOnClickListener(this);
        button1 = findViewById(R.id.ansbutton1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.ansbutton2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.ansbutton3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.ansbutton4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.ansbutton5);
        button5.setOnClickListener(this);
        QuestionBox = findViewById(R.id.QuestionView);
        resultBox = findViewById(R.id.ResulttextView);
        Quitbutton = findViewById(R.id.QuitButton);
        Quitbutton.setOnClickListener(this);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        ViewResultButton.setVisibility(View.GONE);
        Quitbutton.setText("Reset");

        Bundle b = getIntent().getExtras();
        if(b != null)
            qGenerator = (QuestionGenerator) b.getSerializable("Generator");

        question = qGenerator.generateQuestion();
        NextQuestion();
    }
        public void onClick (View v)
        {
            if (numberofQuestions <= 10) {
                resultBox.setVisibility(View.VISIBLE);
                switch (v.getId()) {
                    case R.id.ansbutton1: {
                        numberofQuestions++;
                        if (button1.getText() == answer) {
                            score++;
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it right!", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.BLUE);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        } else {
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.RED);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        }
                        break;
                    }
                    case R.id.ansbutton2: {
                        numberofQuestions++;
                        if (button2.getText() == answer) {
                            score++;
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it right!", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.BLUE);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        } else {
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.RED);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        }
                        break;
                    }
                    case R.id.ansbutton3: {
                        numberofQuestions++;
                        if (button3.getText() == answer) {
                            score++;
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it right!", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.BLUE);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        } else {
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.RED);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        }
                        break;
                    }
                    case R.id.ansbutton4: {
                        numberofQuestions++;
                        if (button4.getText() == answer) {
                            score++;
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it right!", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.BLUE);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        } else {
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.RED);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        }
                        break;
                    }
                    case R.id.ansbutton5: {
                        numberofQuestions++;
                        if (button5.getText() == answer) {
                            score++;
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it right!", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.BLUE);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        } else {
                            Toast toast = Toast.makeText(QuestionsActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
                            View view = toast.getView();

                            view.setBackgroundColor(Color.TRANSPARENT);
                            TextView text = (TextView) view.findViewById(android.R.id.message);
                            toast.setGravity(Gravity.CENTER, 0, -400);
                            text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                            text.setTextColor(Color.RED);
                            LinearLayout toastContentView = (LinearLayout) toast.getView();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                            toastContentView.addView(imageView,0);
                            toast.show();
                            NextQuestion();
                        }
                        break;
                    }
                    case R.id.ResultButton: {
                        resultBox.setText(String.format("You got %d out of 10 questions correct!", score));
                        break;
                    }
                    case R.id.QuitButton: {
                        this.recreate();
                        break;
                    }

                }
            }
            if (numberofQuestions >= 10) {
                GameOver();
            }
        }


    private void GameOver() {
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        ViewResultButton.setVisibility(View.VISIBLE);
    }
    private void NextQuestion()
    {
        question = qGenerator.generateQuestion();
        resultBox.setVisibility(View.VISIBLE);
        QuestionBox.setText(question.getQuestionText());

        ArrayList<String> answers = new ArrayList<String>(5);
        answers.add(question.getRightAnswer());
        answers.add(question.getWrongAnswer1());
        answers.add(question.getWrongAnswer2());
        answers.add(question.getWrongAnswer3());
        answers.add(question.getWrongAnswer4());

        Random random = new Random();

        int number = random.nextInt(answers.size());
        button1.setText(answers.get(number));
        answers.remove(number);

        number = random.nextInt(answers.size());
        button2.setText(answers.get(number));
        answers.remove(number);

        number = random.nextInt(answers.size());
        button3.setText(answers.get(number));
        answers.remove(number);

        number = random.nextInt(answers.size());
        button4.setText(answers.get(number));
        answers.remove(number);

        number = random.nextInt(answers.size());
        button5.setText(answers.get(number));
        answers.remove(number);

        answer = question.getRightAnswer();
    }
}
