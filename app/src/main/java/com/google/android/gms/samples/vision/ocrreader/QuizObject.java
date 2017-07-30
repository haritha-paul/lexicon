package com.google.android.gms.samples.vision.ocrreader;

public class QuizObject {

    private String word;
    private String definition;

    public QuizObject(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }


    public String getDefinition() {
        return definition;
    }


}
