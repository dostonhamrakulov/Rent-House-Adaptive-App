package rtu.group.adaptive.renthouse;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Doston on 12/15/2017.
 */

public class BackgroundTask extends AsyncTask<String, Houses, String> {
    Context context;
    MyDatabaseHelper myDatabaseHelper;

//    UniversityAdapter universityAdapter;
    ListView listView, listView_2;
    Activity activity;

    private static final String COL_1 = "ID";
    private static final String COL_2 = "CITY";
    private static final String COL_3 = "NUM_ROOMS";
    private static final String COL_4= "MIN_PRICE";
    private static final String COL_5 = "MAX_PRICE";
    private static final String COL_6 = "FLOOR";

    private int num_rooms, min_price, max_price, floor;
    private String city;


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
            String min_price = voids[3];
            String max_price = voids[4];
            String floor = voids[5];

            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
            myDatabaseHelper.insertData(city, Integer.parseInt(num_rooms), Integer.parseInt(min_price), Integer.parseInt(max_price), Integer.parseInt(floor));

            return "One row is inserted ... ";
        }

//        else if(methos.equals("get_info")){
//
//            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
//            Cursor cursor = myDatabaseHelper.getInformation(sqLiteDatabase);
//
//            universityAdapter = new UniversityAdapter(context, R.layout.list_university);
//            listView = (ListView) activity.findViewById(R.id.list_view);
//
//            String id, name, fee, program, city, country, continent;
//            int rank;
//            while(cursor.moveToNext()){
//                id = cursor.getString(cursor.getColumnIndex(COL_1));
//                name = cursor.getString(cursor.getColumnIndex(COL_2));
//                //rank = cursor.getString(cursor.getColumnIndex(COL_3));
//                rank = cursor.getInt(cursor.getColumnIndex(COL_3));
//                fee = cursor.getString(cursor.getColumnIndex(COL_4));
//                program = cursor.getString(cursor.getColumnIndex(COL_5));
//                city = cursor.getString(cursor.getColumnIndex(COL_6));
//                country = cursor.getString(cursor.getColumnIndex(COL_7));
//                continent = cursor.getString(cursor.getColumnIndex(COL_8));
//
//                University university = new University(id, name, rank, fee, program, city, country, continent);
//                publishProgress(university);
//
//            }
//
//            return "get_info";
//        } else if (methos.equals("get_adaptive")){
//            SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
//
//            Cursor cursor = myDatabaseHelper.getAdaptiveData(sqLiteDatabase, minimum_rank, maximum_rank, continent);
//
//            universityAdapter = new UniversityAdapter(context, R.layout.activity_adaptive_display);
//            listView_2 = (ListView) activity.findViewById(R.id.list_view_2);
//
//            String id, name, fee, program, city, country, continent;
//            int rank;
//            while(cursor.moveToNext()){
//                id = cursor.getString(cursor.getColumnIndex(COL_1));
//                name = cursor.getString(cursor.getColumnIndex(COL_2));
//                //rank = cursor.getString(cursor.getColumnIndex(COL_3));
//                rank = cursor.getInt(cursor.getColumnIndex(COL_3));
//                fee = cursor.getString(cursor.getColumnIndex(COL_4));
//                program = cursor.getString(cursor.getColumnIndex(COL_5));
//                city = cursor.getString(cursor.getColumnIndex(COL_6));
//                country = cursor.getString(cursor.getColumnIndex(COL_7));
//                continent = cursor.getString(cursor.getColumnIndex(COL_8));
//
//                University university = new University(id, name, rank, fee, program, city, country, continent);
//                publishProgress(university);
//
//            }
//
//            return "get_adaptive";
//        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
//        if (result.equals("get_info")){
//            listView.setAdapter(universityAdapter);
//        } else if (result.equals("get_adaptive")){
//            listView_2.setAdapter(universityAdapter);
//        } else {
//            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//        }

    }

    @Override
    protected void onProgressUpdate(Houses... values) {

//        universityAdapter.add(values[0]);
        super.onProgressUpdate(values);
    }
//    public void setAdaptiveParameters(int min, int max, String continent){
//        this.minimum_rank = min;
//        this.maximum_rank = max;
//        this.continent = continent;
//    }
}
