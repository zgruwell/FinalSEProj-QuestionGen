package com.example.sasha.finalsoftware.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.view.Gravity;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;
import com.example.cs4531.finalsoftware.R;
import com.example.sasha.finalsoftware.model.Question;
import com.example.sasha.finalsoftware.model.QuestionGenerator;

public class CompetitiveQuizActivity extends AppCompatActivity implements View.OnClickListener{
    Random random = new Random();
    private Question question = new Question();
    private int number = random.nextInt(20);
    private TextView resultBox;
    private TextView QuestionBox;
    private TextView currentPlayer;
    private int PlayerOneScore = 0;
    private int PlayerTwoScore = 0;
    private int numberOfQuestions = 0;
    private boolean isPlayerOne = true;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button ViewResultButton;
    Button Quitbutton;
    private String answer;
    QuestionGenerator qGenerator;
    boolean firstQuestion = true;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(CompetitiveQuizActivity.this, R.raw.kappa);
        mediaPlayer.start();
        setContentView(R.layout.activity_competitive);
        ViewResultButton = findViewById(R.id.ResultButton);
        ViewResultButton.setOnClickListener(this);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        QuestionBox = findViewById(R.id.CompetitiveQuestionView);
        resultBox = findViewById(R.id.ResultTextView);
        Quitbutton = findViewById(R.id.QuitButton);
        Quitbutton.setOnClickListener(this);
        currentPlayer = findViewById(R.id.current_player);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        ViewResultButton.setVisibility(View.GONE);
        Quitbutton.setText("Reset Game");

        Bundle b = getIntent().getExtras();
        if(b != null)
            qGenerator = (QuestionGenerator) b.getSerializable("Generator");

        question = qGenerator.generateQuestion();
        NextQuestion();
        ViewResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(FindWinner());
            }
        });

        currentPlayer.setText("Player One");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                numberOfQuestions++;
                if(button1.getText() == answer && isPlayerOne){
                    PlayerOneScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button1.getText() != answer && isPlayerOne){
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button1.getText() == answer && !isPlayerOne){
                    PlayerTwoScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                }else{
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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

            case R.id.button2:
                numberOfQuestions++;
                if(button2.getText() == answer && isPlayerOne){
                    PlayerOneScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button2.getText() != answer && isPlayerOne){
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button2.getText() == answer && !isPlayerOne){
                    PlayerTwoScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                }else{
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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

            case R.id.button3:
                numberOfQuestions++;
                if(button3.getText() == answer && isPlayerOne){
                    PlayerOneScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button3.getText() != answer && isPlayerOne){
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button3.getText() == answer && !isPlayerOne){
                    PlayerTwoScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                }else{
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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

            case R.id.button4:
                numberOfQuestions++;
                if(button4.getText() == answer && isPlayerOne){
                    PlayerOneScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button4.getText() != answer && isPlayerOne){
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button4.getText() == answer && !isPlayerOne){
                    PlayerTwoScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                }else{
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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

            case R.id.button5:
                numberOfQuestions++;
                if(button5.getText() == answer && isPlayerOne){
                    PlayerOneScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button5.getText() != answer && isPlayerOne){
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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
                    SwitchPlayer("Player Two");
                }else if(button5.getText() == answer && !isPlayerOne){
                    PlayerTwoScore++;
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it right!", Toast.LENGTH_SHORT);
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
                }else{
                    Toast toast = Toast.makeText(CompetitiveQuizActivity.this, "You got it wrong.", Toast.LENGTH_SHORT);
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
            case R.id.QuitButton:
            {
                this.recreate();
            }
            break;

        }
        if(numberOfQuestions>=20) {
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
        resultBox.setVisibility(View.VISIBLE);
        resultBox.setText("Player 1 has: " + PlayerOneScore + " points! \n" + "Player 2 has: " + PlayerTwoScore + " points!");
        if(!firstQuestion){
            SwitchPlayer("Player One");
        }else{
            firstQuestion = !firstQuestion;
        }

        question = qGenerator.generateQuestion();
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

    private void SwitchPlayer(String player){
        currentPlayer.setText(player);
        isPlayerOne = !isPlayerOne;
    }

    private String FindWinner(){
        if(PlayerOneScore > PlayerTwoScore){
            return "Player one is the winner!";
        }
        else if(PlayerOneScore == PlayerTwoScore){
            return "It is a tie!";
        }
        else{
            return "Player two is the winner!";
        }
    }
}
