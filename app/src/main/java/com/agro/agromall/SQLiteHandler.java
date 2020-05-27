package com.agro.agromall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.agro.agromall.models.MHome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.sql.Types.NULL;


public class SQLiteHandler extends SQLiteOpenHelper {

        private static final String TAG = SQLiteHandler.class.getSimpleName();

        // All Static variables
        // Database Version
        private static final int DATABASE_VERSION = 1;

        // Database Name
        private static final String DATABASE_NAME = "agroMall";

        // Login table name
        private static final String TABLE_USER = "user";
        // MarketPlace table name
        private static final String TABLE_FARMER_DETAIL = "farmerDetail";

        // Farmers' Details Table Columns names
        private static final String ID = "id";
        private static final String KEY_UID = "uid";
        private static final String KEY_FULL_NAME= "full_name";
        private static final String KEY_EMAIL = "email";
        private static final String KEY_PHONE_NUMBER = "phone_number";
        private static final String KEY_HOME_ADDRESS = "home_address";
        private static final String KEY_FARMER_PICTURE = "farmer_picture";
        private static final String KEY_FARM_NAME = "farm_name";
        private static final String KEY_FARM_ADDRESS= "farm_address";
        private static final String KEY_LONGITUDE= "longitude";
        private static final String KEY_LATITUDE= "latitude";
        private static final String KEY_CREATED_AT = "created_at";


        // User Table Columns names
        private static final String KEY_ID = "id";
        private static final String KEY_USER_EMAIL = "email";
        private static final String KEY_PASSWORD = "password";

        public SQLiteHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        // Creating Tables
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_FARMER_DETAIL_TABLE = "CREATE TABLE " + TABLE_FARMER_DETAIL + "("
                    + ID + " INTEGER PRIMARY KEY," + KEY_UID + " TEXT," + KEY_FULL_NAME + " TEXT,"
                    + KEY_EMAIL + " TEXT UNIQUE," + KEY_PHONE_NUMBER + " TEXT," + KEY_HOME_ADDRESS + " TEXT," + KEY_FARMER_PICTURE + " TEXT,"
                    + KEY_FARM_NAME + " TEXT," + KEY_FARM_ADDRESS + " TEXT,"+ KEY_LONGITUDE + " TEXT,"+ KEY_LATITUDE + " TEXT,"+KEY_CREATED_AT + " TEXT" + ")";
            db.execSQL(CREATE_FARMER_DETAIL_TABLE);

            String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                    + ID + " INTEGER PRIMARY KEY," + KEY_USER_EMAIL + " TEXT,"
                    + KEY_PASSWORD + " TEXT" + ")";
            db.execSQL(CREATE_USER_TABLE);

            Log.d(TAG, "Database tables created");
        }

        // Upgrading database
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FARMER_DETAIL);

            // Create tables again
            onCreate(db);
        }

        /**
         * Storing user details in database
         * */
        public void addFarmer1(String full_name, String email, String uid, String phone_number,String home_address, String created_at) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_FULL_NAME, full_name); // Name
            values.put(KEY_EMAIL, email); // Email
            values.put(KEY_PHONE_NUMBER, phone_number); // Email
            values.put(KEY_HOME_ADDRESS, home_address); // Email
            values.put(KEY_UID, uid); // Email
            values.put(KEY_FARMER_PICTURE, NULL); // Email
            values.put(KEY_FARM_NAME, NULL); // Email
            values.put(KEY_FARM_ADDRESS, NULL); // Email
            values.put(KEY_LONGITUDE, NULL); // Email
            values.put(KEY_LATITUDE, NULL); // Email
            values.put(KEY_CREATED_AT, created_at); // Created At

            // Inserting Row
            long id = db.insert(TABLE_FARMER_DETAIL, null, values);
            db.close(); // Closing database connection

            Log.d(TAG, "New user inserted into SQLite: " + id);
        }

    public void UpdateFarmer2(String farmer_picture, String uid, String created_at) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FARMER_PICTURE, farmer_picture);// userName
        values.put(KEY_CREATED_AT, created_at); // Created At

        // Inserting Row
        long id = db.update(TABLE_USER, values,KEY_UID + "=" + uid, null );
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

        public void UpdateFarmer3(String farm_name, String farm_address, String uid, String longitude, String latitude, String created_at) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_FARM_NAME, farm_name); // Name
            values.put(KEY_FARM_ADDRESS, farm_address); // userName
            values.put(KEY_LONGITUDE, longitude); // Email
            values.put(KEY_LATITUDE, latitude); // Email
            values.put(KEY_CREATED_AT, created_at); // Created At

            // Inserting Row
            long id = db.update(TABLE_USER, values,KEY_UID + "=" + uid, null );
            db.close(); // Closing database connection

            Log.d(TAG, "New user inserted into sqlite: " + id);
        }

        /**
         * Getting user data from database
         * */
        public HashMap<String, String> getUserDetails() {
            HashMap<String, String> user = new HashMap<String, String>();
            String selectQuery = "SELECT  * FROM " + TABLE_FARMER_DETAIL;

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            /*public List<MHome> getMusic(List<MHome> farms) {
                List<MHome> musicList= new ArrayList<>();
                int size = farms.size();

                SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
                try {
                    for(int i = 0; i < size; i++) {
                        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_FARMER_DETAIL, null);
                        cursor.moveToFirst();

                        while (!cursor.isAfterLast()) {
                            MHome farm = new MHome();
                            String title = farm.(cursor.getString(1));
                            if(soundex(genre.equals(title ))
                            {
                                musicList.add(music);
                            }

                            cursor.moveToNext();
                        }
                        cursor.close();
                    }
                    sqLiteDatabase.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    sqLiteDatabase.close();
                }
                return musicList;
            }*/
            // Move to first row
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                user.put("uid", cursor.getString(1));
                user.put("full_name", cursor.getString(2));
                user.put("email", cursor.getString(3));
                user.put("phone_number", cursor.getString(4));
                user.put("home_address", cursor.getString(5));
                user.put("farmer_picture", cursor.getString(6));
                user.put("farm_name", cursor.getString(7));
                user.put("farm_address", cursor.getString(8));
                user.put("longitude", cursor.getString(9));
                user.put("latitude", cursor.getString(10));
                user.put("created_at", cursor.getString(11));
            }
            cursor.close();
            db.close();
            // return user
            Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

            return user;
        }

    }

