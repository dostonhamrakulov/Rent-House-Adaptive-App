package rtu.group.adaptive.renthouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Inserting extends AppCompatActivity {

    EditText number_rooms, price, floors, period;
    Spinner cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);

        number_rooms = (EditText)findViewById(R.id.edit_rooms);
        price = (EditText)findViewById(R.id.edit_price);
        period = (EditText)findViewById(R.id.edit_period);

        cities = (Spinner) findViewById(R.id.edit_city);
        floors = (EditText)findViewById(R.id.edit_floor);


    }
    public void AddData(View view){
//        myDatabaseHelper.insertData(name1.getText().toString(), ranking1.getText().toString(),
//                fee1.getText().toString(), program1.getText().toString(), city1.getText().toString(),
//                country1.getText().toString(), continent1.getText().toString());

        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute("add_info", cities.getSelectedItem().toString(), number_rooms.getText().toString(),
                price.getText().toString(), period.getText().toString(), floors.getText().toString());

        Toast.makeText(Inserting.this, "New data inserted!", Toast.LENGTH_LONG).show();

        //cities.setText("");
        number_rooms.setText("");
        price.setText("");
        period.setText("");
        floors.setText("");




    }
}
