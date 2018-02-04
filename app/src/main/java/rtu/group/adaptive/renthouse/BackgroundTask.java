package rtu.group.adaptive.renthouse;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;


public class BackgroundTask extends AsyncTask<String, Houses, String> {
    Context context;
    MyDatabaseHelper myDatabaseHelper;

//    UniversityAdapter universityAdapter;
    HousesAdapter housesAdapter;
    ListView listView, listView_2;
    Activity activity;

    private int num_rooms_1;
    private int min_price_1;
    private int max_price_1;
    private String city_1;

    private static final String COL_1 = "ID";
    private static final String COL_2 = "CITY";
    private static final String COL_3 = "NUM_ROOMS";
    private static final String COL_4= "PRICE";
    private static final String COL_5 = "MIN_PERIOD";
    private static final String COL_6 = "FLOOR";
    private static final String COL_7 = "ADDRESS";
    private static final String COL_8 = "PHONE";

    BackgroundTask(Context ctx){
        this.context = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected String doInBackground(String... voids) {

        myDatabaseHelper =  new MyDatabaseHelper(context);

        String methos = voids[0];
        if (methos.equals("add_info")){
            String city = voids[1];
            String num_rooms = voids[2];
            String price = voids[3];
            String period = voids[4];
            String floor = voids[5];
            String address = voids[6];
            String phone = voids[7];

            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
            myDatabaseHelper.insertData(city, Integer.parseInt(num_rooms), Integer.parseInt(price), Integer.parseInt(period), Integer.parseInt(floor), address, phone);

            return "One row is inserted ... ";
        }

        else if(methos.equals("get_info")){

            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
            Cursor cursor = myDatabaseHelper.getInformation(sqLiteDatabase);

            housesAdapter = new HousesAdapter(context, R.layout.list_houses);
            listView = (ListView) activity.findViewById(R.id.list_view);

            String id_1, city_1, addrees_1, phone_1;
            int num_rooms_12, price_12, period_12, floor_12;

            while(cursor.moveToNext()){
                id_1 = cursor.getString(cursor.getColumnIndex(COL_1));
                city_1 = cursor.getString(cursor.getColumnIndex(COL_2));
                num_rooms_12 = cursor.getInt(cursor.getColumnIndex(COL_3));
                price_12 = cursor.getInt(cursor.getColumnIndex(COL_4));
                period_12 = cursor.getInt(cursor.getColumnIndex(COL_5));
                floor_12 = cursor.getInt(cursor.getColumnIndex(COL_6));
                addrees_1 = cursor.getString(cursor.getColumnIndex(COL_7));
                phone_1 = cursor.getString(cursor.getColumnIndex(COL_8));
                Houses houses = new Houses(id_1, city_1, num_rooms_12, price_12, period_12, floor_12, addrees_1, phone_1);
                publishProgress(houses);

            }

            return "get_info";
        } else if (methos.equals("get_adaptive")){
            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();

            Cursor cursor = myDatabaseHelper.getAdaptiveData(sqLiteDatabase, num_rooms_1, min_price_1, max_price_1, city_1);

            housesAdapter = new HousesAdapter(context, R.layout.activity_adaptive_display);
            listView_2 = (ListView) activity.findViewById(R.id.list_view_2);

            String id_2, city_2, addrees_2, phone_2;
            int num_rooms_2, price_2, period_2, floor_2;

            while(cursor.moveToNext()){
                id_2 = cursor.getString(cursor.getColumnIndex(COL_1));
                city_2 = cursor.getString(cursor.getColumnIndex(COL_2));
                num_rooms_2 = cursor.getInt(cursor.getColumnIndex(COL_3));
                price_2 = cursor.getInt(cursor.getColumnIndex(COL_4));
                period_2 = cursor.getInt(cursor.getColumnIndex(COL_5));
                floor_2 = cursor.getInt(cursor.getColumnIndex(COL_6));
                addrees_2 = cursor.getString(cursor.getColumnIndex(COL_7));
                phone_2 = cursor.getString(cursor.getColumnIndex(COL_8));
                Houses houses = new Houses(id_2, city_2, num_rooms_2, price_2, period_2, floor_2, addrees_2, phone_2);
                publishProgress(houses);

            }

            return "get_adaptive";
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("get_info")){
            listView.setAdapter(housesAdapter);
        } else if (result.equals("get_adaptive")){
            listView_2.setAdapter(housesAdapter);
        } else {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onProgressUpdate(Houses... values) {

        housesAdapter.add(values[0]);
        super.onProgressUpdate(values);
    }
    public void setAdaptiveParameters(int num_rooms_1, int min_price_1, int max_price_1, String city_1){
        this.num_rooms_1 = num_rooms_1;
        this.min_price_1 = min_price_1;
        this.max_price_1 = max_price_1;
        this.city_1 = city_1;
    }
}
