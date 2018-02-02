package rtu.group.adaptive.renthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchHouse extends AppCompatActivity {

    EditText num_rooms, min_price, max_price;
    Spinner city;
    Button get_adaptive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_house);

        num_rooms = (EditText)findViewById(R.id.take_num_rooms);
        min_price = (EditText)findViewById(R.id.take_min_price);
        max_price = (EditText)findViewById(R.id.take_max_price);
        city = (Spinner)findViewById(R.id.take_city);
        get_adaptive = (Button)findViewById(R.id.get_result);


        get_adaptive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SearchHouse.this, AdaptiveDisplay.class);
                        intent.putExtra("Number_rooms", num_rooms.getText().toString());
                        intent.putExtra("Minimum_price", min_price.getText().toString());
                        intent.putExtra("Maximum_price", max_price.getText().toString());
                        intent.putExtra("City", city.getSelectedItem().toString());
                        startActivity(intent);
                        Toast.makeText(SearchHouse.this, "It is still in process!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}
