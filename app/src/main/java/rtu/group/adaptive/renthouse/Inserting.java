package rtu.group.adaptive.renthouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Inserting extends AppCompatActivity {

    EditText number_rooms, price_min, floors, price_max;
    Spinner cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);

        number_rooms = (EditText)findViewById(R.id.edit_rooms);
        price_min = (EditText)findViewById(R.id.edit_max_price);
        price_max = (EditText)findViewById(R.id.edit_min_price);

        cities = (Spinner) findViewById(R.id.edit_city);
        floors = (EditText)findViewById(R.id.edit_floor);


    }
    public void AddData(View view){
//        myDatabaseHelper.insertData(name1.getText().toString(), ranking1.getText().toString(),
//                fee1.getText().toString(), program1.getText().toString(), city1.getText().toString(),
//                country1.getText().toString(), continent1.getText().toString());

        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute("add_info", cities.getSelectedItem().toString(), number_rooms.getText().toString(),
                price_min.getText().toString(), price_max.getText().toString(), floors.getText().toString());

        Toast.makeText(Inserting.this, "New data inserted!", Toast.LENGTH_LONG).show();

        //cities.setText("");
        number_rooms.setText("");
        price_min.setText("");
        price_max.setText("");
        floors.setText("");




    }
}
