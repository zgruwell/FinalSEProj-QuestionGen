package com.example.sasha.finalsoftware.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class QuestionGenerator implements Serializable {

    ArrayList<Integer> usedQuestions = new ArrayList<Integer>(29);
    int number;

    public QuestionGenerator() { }

    public Question generateQuestion() {
        Random random = new Random();

        while(this.inArray(number)) {
            number = random.nextInt(29); }

        usedQuestions.add(number);
        Question newQuestion = new Question(number);

        return newQuestion;
    }

    private boolean inArray(int number) {
        for (int i = 0; i < usedQuestions.size(); i++) {
            if (number == usedQuestions.get(i)) {
                return true;
            }
        }
        return false;
    }
}