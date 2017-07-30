package com.google.android.gms.samples.vision.ocrreader;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity {

    private TextView wordMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("DICTIONARY_ID");

        TextView word = (TextView)findViewById(R.id.word);
        wordMeaning = (TextView)findViewById(R.id.dictionary);
        Button textToSpeech = (Button)findViewById(R.id.button);

        DbBackend dbBackend = new DbBackend(DictionaryActivity.this);
        QuizObject allQuizQuestions = dbBackend.getQuizById(id);
        if(allQuizQuestions != null) {
            word.setText(allQuizQuestions.getWord());
            wordMeaning.setText(allQuizQuestions.getDefinition());
        }
        else
            wordMeaning.setText("Meaning not available");


    }
}
