package com.google.android.gms.samples.vision.ocrreader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbObject {

    private static com.google.android.gms.samples.vision.ocrreader.DictionaryDatabase dbHelper;
    private SQLiteDatabase db;

    public DbObject(Context context) {
        dbHelper = new com.google.android.gms.samples.vision.ocrreader.DictionaryDatabase(context);
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }

    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }
}

