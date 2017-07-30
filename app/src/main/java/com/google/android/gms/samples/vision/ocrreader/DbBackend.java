package com.google.android.gms.samples.vision.ocrreader;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DbBackend extends com.google.android.gms.samples.vision.ocrreader.DbObject {

    public DbBackend(Context context) {
        super(context);
    }

    public String[] dictionaryWords(){
        String query = "Select * from dictionary";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> wordTerms = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                String word = cursor.getString(cursor.getColumnIndexOrThrow("word"));
                wordTerms.add(word);
            }while(cursor.moveToNext());
        }
        cursor.close();
        String[] dictionaryWords = new String[wordTerms.size()];
        dictionaryWords = wordTerms.toArray(dictionaryWords);
        return dictionaryWords;
    }


    public com.google.android.gms.samples.vision.ocrreader.QuizObject getQuizById(int quizId){

        com.google.android.gms.samples.vision.ocrreader.QuizObject quizObject = null;
        String t =  MainActivity.value[quizId];
       // String query = "select * from dictionary where word = 'Anther '" ;
        String query = "select * from dictionary where word = " + "'"+ t +"'" ;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String word = cursor.getString(cursor.getColumnIndexOrThrow("word"));
                String meaning = cursor.getString(cursor.getColumnIndexOrThrow("meaning"));
                quizObject = new QuizObject(word, meaning);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return quizObject;
    }
}
