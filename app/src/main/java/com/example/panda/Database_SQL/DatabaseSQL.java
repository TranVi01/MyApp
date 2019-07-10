package com.example.panda.Database_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.panda.Models.Accout_Information;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public class DatabaseSQL extends SQLiteOpenHelper {


    private static final String TAG = "SQLite";

    // Phiên bản
    private static final int DATABASE_VERSION = 1;

    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "Accout_database";

    public  DatabaseSQL(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tên bảng
    private static final String TABLE_ACCOUT = "Accout";
    private static final String COLUMN_ID ="accout_ID";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = " phone ";
//    private static final String COLUMN_IMAGE = " image ";


    private String script = " CREATE TABLE " + TABLE_ACCOUT + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT , "
            + COLUMN_EMAIL + " TEXT , "
            + COLUMN_PHONE + " TEXT " + ")";
//            + COLUMN_IMAGE + " BLOB " + ")";




    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "DatabaseSQL.onCreate accout...");
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUT);
        this.onCreate(db);
    }

    public void QueryData (String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData (String sql) {
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql, null);
    }

//    public void INSERT_ACCOUT (Accout_Information accout_information){
//
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, accout_information.getName() );
//        values.put(COLUMN_EMAIL, accout_information.getEmail());
//        values.put(COLUMN_PHONE, accout_information.getPhone());
//        values.put(COLUMN_IMAGE,accout_information.getImage());
//
//        sqLiteDatabase.insert(TABLE_ACCOUT, null, values);
//        sqLiteDatabase.close();
//        Log.d(TAG, "addStudent Successfuly");


    public void insert_Accout (String name, String email, String numberphone){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "INSERT INTO Accout VALUES( NULL, ? , ?, ? )";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, name);
        sqLiteStatement.bindString(2, email);
        sqLiteStatement.bindString(3, numberphone);
//        sqLiteStatement.bindBlob(4, image);
        sqLiteStatement.executeInsert();
        sqLiteDatabase.close();
        Log.d(TAG, "addAccout Successfuly");
    }

    public Accout_Information getAccout (int accoutId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ACCOUT, null, COLUMN_ID + " = ?",
                new String[] { String.valueOf(accoutId) },null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Accout_Information accout = new Accout_Information(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getBlob(4));
        return accout;
    }

    public List<Accout_Information> getAllAccout() {
        List<Accout_Information>  accoutList = new ArrayList<>();
        String query = " SELECT * FROM " + TABLE_ACCOUT ;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            Accout_Information accout = new Accout_Information(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4));
            accoutList.add(accout);
            cursor.moveToNext();
        }
        return accoutList;
    }

    public void updateAccout(String name, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
//        values.put(COLUMN_IMAGE, accout_information.getImage());

        db.update(TABLE_ACCOUT, values, COLUMN_ID + " = ?", new String[] { String.valueOf(0) });
        Log.d(TAG,"update Successfuly");
        db.close();
    }

    public void deleteAccout(int AccoutId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACCOUT, COLUMN_ID + " = ?", new String[] { String.valueOf(AccoutId)});
    }

}
