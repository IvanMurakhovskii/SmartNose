package com.murik.smartnose.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.murik.smartnose.models.DateGroup;
import com.murik.smartnose.models.DateTime;
import com.murik.smartnose.models.Time;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper{

    private static String DB_NAME = "E_NoseDb";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "BODY";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATETIME = "date";
    private static final String COLUMN_SESSION = "session";


    private static final String COLUMN_SENSOR_1 = "sensor1";
    private static final String COLUMN_SENSOR_2 = "sensor2";
    private static final String COLUMN_SENSOR_3 = "sensor3";
    private static final String COLUMN_SENSOR_4 = "sensor4";
    private static final String COLUMN_SENSOR_5 = "sensor5";
    private static final String COLUMN_SENSOR_6 = "sensor6";
    private static final String COLUMN_SENSOR_7 = "sensor7";
    private static final String COLUMN_SENSOR_8 = "sensor8";


    private static final String[] ARR_SENSOR = new String[] {COLUMN_SENSOR_1, COLUMN_SENSOR_2,
            COLUMN_SENSOR_3, COLUMN_SENSOR_4, COLUMN_SENSOR_5, COLUMN_SENSOR_6,
            COLUMN_SENSOR_7, COLUMN_SENSOR_8};



    private static final String DB_CREATE = "CREATE TABLE " + DB_TABLE + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_DATETIME + " INTEGER, " +
            COLUMN_SENSOR_1 + " INTEGER, " +
            COLUMN_SENSOR_2 + " INTEGER, " +
            COLUMN_SENSOR_3 + " INTEGER, " +
            COLUMN_SENSOR_4 + " INTEGER, " +
            COLUMN_SENSOR_5 + " INTEGER, " +
            COLUMN_SENSOR_6 + " INTEGER, " +
            COLUMN_SENSOR_7 + " INTEGER, " +
            COLUMN_SENSOR_8 + " INTEGER," +
            COLUMN_SESSION +  " INTEGER " +
            ");";

   private SQLiteDatabase mDB;

    public DBHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


    public void addSensorCount (int[] arrSensor, long date, long date_session) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        int numberOfSensors = 8;
        cv.put(COLUMN_DATETIME, date);
        cv.put(COLUMN_SESSION, date_session);
        for(int i = 0; i < numberOfSensors; i++){
            cv.put(ARR_SENSOR[i], arrSensor[i]);
        }

        db.insert(DB_TABLE, null, cv);
        db.close();
    }

    public long getId(int pos) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cur = null;
        long result = 1l;
        if(db != null) {
            try {
                cur = db.query(DB_TABLE, new String[]{COLUMN_SESSION}, COLUMN_ID+"=?", new String[]{String.valueOf(pos)}, null, null, null);
                cur.moveToFirst();
                result = cur.getLong(cur.getColumnIndexOrThrow(COLUMN_SESSION));
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (cur != null) {
                    cur.close();
                }
                db.close();
            }
        }
            return result;
    }

   public int getMaxSensorCount(long millis){
       SQLiteDatabase db = getReadableDatabase();
       int a = 0;
       Cursor cur = null;
       if(db != null) {
           try {
               /*cur = db.query(DB_TABLE,
                       new String[]{COLUMN_SENSOR_1},
                       null,
                       null,
                       null,
                       null,
                       null);

               cur.moveToFirst();
                a = cur.getInt(cur.getColumnIndexOrThrow(COLUMN_SENSOR_1));*/



           } catch (Exception ex) {
               ex.printStackTrace();
           } finally {
               if (cur != null) {
                   cur.close();
               }
               db.close();
           }
       }
       return a;

   }


    public List<DateGroup> getDateSession() {
        SQLiteDatabase db = getReadableDatabase();
        List<DateGroup> date = new ArrayList<>();

        String tmpDate = "";
        String tmpTime = "";
        //---------------------

        //---------------------
        Cursor cur = null;
        if(db != null){
            try{
                cur = db.query(DB_TABLE,
                        new String[]{COLUMN_SESSION},
                        null,
                        null,
                        null,
                        null,
                        null);

                cur.moveToFirst();
                long millis = cur.getLong(cur.getColumnIndexOrThrow(COLUMN_SESSION));
                tmpDate =  DateTime.getDateFormat(millis);
                List<Time> times = new ArrayList<>();

                do{

                    millis = cur.getLong(cur.getColumnIndexOrThrow(COLUMN_SESSION));

                    if(tmpDate.equals(DateTime.getDateFormat(millis))){

                        if(!tmpTime.equals(DateTime.getTimeFormat(millis))){
                            times.add(new Time(millis));
                            tmpTime = DateTime.getTimeFormat(millis);
                        }
                    } else {
                        date.add(new DateGroup(tmpDate, times));
                        tmpDate =  DateTime.getDateFormat(millis);
                        times = new ArrayList<>();

                    }

                }while (cur.moveToNext() != false);
                date.add(new DateGroup(tmpDate, times));
            }catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                if (cur != null){
                    cur.close();
                }
                db.close();
            }
        }
        return date;
    }


}
