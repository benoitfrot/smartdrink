package com.example.achille.grostest.PPE_BENOIT;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by benoi_000 on 16/02/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TAG="DATABASE_CREATION";
    //Databse version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "UsersDB";

    // users table name
    private static final String TABLE_USERS= "users";
    private static final String TABLE_GLASS="verres";

    // users Table Columns names
    private static final String PRIMARY_KEY_MAIL = "email";
    private static final String KEY_USRNAME="username";
    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_LAST_NAME = "lastName";
    private static final String KEY_BIRTHDAY = "birthday";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_ORIGINS = "origins";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_ALCOOL_LEVEL="alcoolLevel";
    private static final String KEY_HASHED_PASSWORD ="hashedPassword";
    private static final String KEY_SALT="salt";

    //Glass Table Columns names
    private static final String PRIMARY_KEY_NAME = "nomVerre";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_FUNCTION = "fonction";

    private SQLiteDatabase db;

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + PRIMARY_KEY_MAIL + " STRING PRIMARY KEY, " + KEY_USRNAME + " TEXT, "
                + KEY_FIRST_NAME + " TEXT, " + KEY_LAST_NAME + " TEXT, " + KEY_BIRTHDAY + " TEXT, " +  KEY_WEIGHT + " TEXT, "
                + KEY_HEIGHT + " TEXT, " + KEY_ORIGINS + " TEXT, " + KEY_GENDER + " TEXT, "+ KEY_ALCOOL_LEVEL + " TEXT, "
                + KEY_HASHED_PASSWORD + " VARBINARY(1024), "+KEY_SALT+" VARBINARY(1024) " +")";
        db.execSQL(CREATE_USERS_TABLE);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GLASS);
        CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_GLASS + "("
                + PRIMARY_KEY_NAME + " STRING PRIMARY KEY, " + KEY_IMAGE + " BLOB, "
                + KEY_FUNCTION + " BLOB " +")";
        db.execSQL(CREATE_USERS_TABLE);

        ContentValues values = new ContentValues();
        //Verre à eau
        values.put(PRIMARY_KEY_NAME,"verre_a_eau");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x) = 2,5*x ");
        db.insert(TABLE_GLASS, null, values);

        //verre en biais
        values.put(PRIMARY_KEY_NAME,"verre_en_biais");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x)= 3*10^(-10)*x^(6) + 8*10^(-8)*x^5 - 3*10^(-5)*x^4 + 0,0021*x^3 - 0,0588*x^2 + 2,2805*x - 5,5873 ");
        db.insert(TABLE_GLASS, null, values);

        //verre a shot
        values.put(PRIMARY_KEY_NAME,"verre_a_shot");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x)= -5*10^(-9)*x^6 + 610^(-7)*x*5 - 610^(-5)*x^4 + 0,0043*x^3 - 0,1493*x^2 + 3,1396*x - 12,574");
        db.insert(TABLE_GLASS, null, values);

        //verre a champagne
        values.put(PRIMARY_KEY_NAME,"verre_a_champagne");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x)= -4*10^(-9)*x^6 + 10^(-6)*x^5 - 0,0001*x^4 + 0,0073*x^3 - 0,1849*x^2 + 2,6053*x - 12,693");
        db.insert(TABLE_GLASS, null, values);

        //verre a vin
        values.put(PRIMARY_KEY_NAME,"verre_a_vin");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x)=4*10^(-8)*x6 - 910^(-6)*x^5 + 0,0009*x^4 - 0,0428*x^3 + 1,0933*x^2 - 12,824*x + 59,127");
        db.insert(TABLE_GLASS, null, values);

        //verre a whisky
        values.put(PRIMARY_KEY_NAME,"verre_a_whisky");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x)= 0,003*x^2 + 2,2822*x - 2,8043");
        db.insert(TABLE_GLASS, null, values);

        //verre a bière
        values.put(PRIMARY_KEY_NAME,"verre_a_bière");
        values.put(KEY_IMAGE," ");
        values.put(KEY_FUNCTION,"f(x)=7*10^(-11)*x^6 - 310^(-8)*x^5 + 410^(-6)*x^4 - 0,0003*x^3 + 0,0199*x^2 + 0,3843*x + 3,373");
        db.insert(TABLE_GLASS, null, values);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    // Adding new user
    public boolean addUser(User user) {
        db=this.getWritableDatabase();
        if (getUser(user.getEmail())==null)
        {

            ContentValues values = new ContentValues();
            values.put(PRIMARY_KEY_MAIL, user.getEmail()); // user Mail
            values.put(KEY_USRNAME, user.getUsername()); // user Phone Number
            values.put(KEY_FIRST_NAME, user.getFirstName()); // user Fname
            values.put(KEY_LAST_NAME, user.getLastName()); // user Lname
            values.put(KEY_BIRTHDAY, user.getBirthday()); // user Birthday
            values.put(KEY_WEIGHT, user.getWeight()); // user weight
            values.put(KEY_HEIGHT, user.getHeight()); // user height
            values.put(KEY_ORIGINS, user.getOrigins()); // user origin
            values.put(KEY_GENDER, user.getGender()); // user gender
            values.put(KEY_ALCOOL_LEVEL, user.getAlcoholLevel());// user Alcool level
            values.put(KEY_HASHED_PASSWORD, user.getPassword().getHashedPassword());//user's HAshed PAssword
            values.put(KEY_SALT, user.getPassword().getSalt());//User's Salt;


            // Inserting Row
            db.insert(TABLE_USERS, null, values);
            //db.close(); // Closing database connection

            return true;
        }

        else{
            return false;
        }

    }

    // Getting single user
    public User getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[] { PRIMARY_KEY_MAIL,
                        KEY_USRNAME, KEY_FIRST_NAME, KEY_LAST_NAME, KEY_BIRTHDAY, KEY_WEIGHT, KEY_HEIGHT,
                        KEY_ORIGINS, KEY_GENDER, KEY_ALCOOL_LEVEL, KEY_HASHED_PASSWORD,KEY_SALT }, PRIMARY_KEY_MAIL + "=?",
                new String[] { String.valueOf(email) }, null, null, null, null);
        User usr;
        if ((cursor != null)&&(cursor.getCount()>0)) {
            cursor.moveToFirst();

            usr = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8),
                    null, null, cursor.getInt(9), cursor.getBlob(10),cursor.getBlob(11));
            return usr;
        }
        // return user
        return null;

    }
    // Getting All users
    public ArrayList<User> getAllUsers() {
        db=this.getWritableDatabase();
        ArrayList<User> UserList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;


        Cursor cursor = db.rawQuery(selectQuery, null);
        int index = 0;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            try {
                // cursor.getInt(0);
                //index++;

            } catch (IllegalStateException e) {
                e.printStackTrace();

            }


            do {
                User User = new User();

                User.setEmail(cursor.getString(0));
               User.setUsername(cursor.getString(1));
                User.setFirstName(cursor.getString(2));
                User.setLastName(cursor.getString(3));
                User.setBirthday(cursor.getString(4));
                User.setWeight(cursor.getInt(5));
                User.setHeight(cursor.getInt(6));
                User.setOrigins(cursor.getString(7));
                User.setGender(cursor.getString(8));
                User.setAlcoholLevel(cursor.getInt(9));
                User.Password p = new User.Password(cursor.getBlob(10), cursor.getBlob(11));
                User.setPassword(p);

                // User.getPassword().setHashedPassword(cursor.getBlob(10));
                // User.getPassword().setSalt(cursor.getBlob(11));

                // Adding User to list
                UserList.add(User);
            } while (cursor.moveToNext());

        }

        // return User list
        return UserList;
    }

    public String getGlasse() throws UnsupportedEncodingException {
        String res="";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<User> UserList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_GLASS;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                res +="GName : "+cursor.getString(0)+"\n";
                res+="IMG : "+ new String(cursor.getBlob(1),"UTF-8")+"\n";
                res+="func : "+ new String(cursor.getBlob(2),"UTF-8")+"\n";


            } while (cursor.moveToNext());
        }
        return res;
    }

    // Getting Users Count
    public int getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);


        // return count
        int  res = cursor.getCount();
        cursor.close();
        return res;
    }
    // Updating single user
    public int updateUser(User user) {


        ContentValues values = new ContentValues();
        values.put(PRIMARY_KEY_MAIL, user.getEmail()); // user Mail
        values.put(KEY_USRNAME, user.getUsername()); // user Phone Number
        values.put(KEY_FIRST_NAME, user.getFirstName()); // user Fname
        values.put(KEY_LAST_NAME, user.getLastName()); // user Lname
        values.put(KEY_BIRTHDAY, user.getBirthday()); // user Birthday
        values.put(KEY_WEIGHT, user.getWeight()); // user weight
        values.put(KEY_HEIGHT, user.getHeight()); // user height
        values.put(KEY_ORIGINS, user.getOrigins()); // user origin
        values.put(KEY_GENDER, user.getGender()); // user gender
        values.put(KEY_ALCOOL_LEVEL, user.getAlcoholLevel());// user Alcool level
        values.put(KEY_HASHED_PASSWORD, user.getPassword().getHashedPassword());
        values.put(KEY_SALT, user.getPassword().getSalt());


        // updating row
        return db.update(TABLE_USERS, values, PRIMARY_KEY_MAIL + " = ?",
                new String[] { String.valueOf(user.getEmail()) });
    }

    // Deleting single user
    public void deleteContact(User usr) {
        db=this.getWritableDatabase();

        db.delete(TABLE_USERS, PRIMARY_KEY_MAIL + " = ?",
                new String[] { String.valueOf(usr.getEmail()) });
        //db.close();
    }

    public String toString()
    {
        String res =" ";
        ArrayList list = this.getAllUsers();
        Iterator itr = list.iterator();
        while(itr.hasNext())
        {
            User aux = (User) itr.next();
            res += aux.toString();
        }
        return res;
    }

    public String saveDBToFile(){
        String res="";
        ArrayList<User> list = this.getAllUsers();
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            User aux = (User) itr.next();
            res+=aux.saveDBToFile();
        }
        return res;

    }



}
