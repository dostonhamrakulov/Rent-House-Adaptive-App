package rtu.group.adaptive.renthouse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Doston on 12/15/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HOUSES.DB";
    private static final String TABLE_NAME = "house_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "CITY";
    private static final String COL_3 = "NUM_ROOMS";
    private static final String COL_4= "MIN_PRICE";
    private static final String COL_5 = "MAX_PRICE";
    private static final String COL_6 = "FLOOR";
    private static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" +
            COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_2 + " TEXT, " +
            COL_3 + " INTEGER, " +
            COL_4 + " INTEGER, " +
            COL_5 + " INTEGER, " +
            COL_6 + " INTEGER);";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


    }
    public void insertData(String city, int num_rooms, int min_price, int max_price, int floor){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, city);
        contentValues.put(COL_3, num_rooms);
        contentValues.put(COL_4, min_price);
        contentValues.put(COL_5, max_price);
        contentValues.put(COL_6, floor);
        db.insert(TABLE_NAME, null, contentValues);

    }
    public Cursor getInformation(SQLiteDatabase sqLiteDatabase){

        String[] projections = {COL_1, COL_2, COL_3, COL_4, COL_5, COL_6};
        Cursor cursor =  sqLiteDatabase.query(TABLE_NAME, projections, null, null, null, null, null);

        return cursor;
    }

    public Cursor getAdaptiveData(SQLiteDatabase sqLiteDatabase, int min_price, int max_price, String city){

        Cursor res = sqLiteDatabase.rawQuery(" select * from " + TABLE_NAME +
                " as U where (U.MAX_PRICE < " + max_price + " AND U.MIN_PRICE >  " + min_price +
                " AND U.CITY = '" + city + "');", null);

        return res;
    }
}
