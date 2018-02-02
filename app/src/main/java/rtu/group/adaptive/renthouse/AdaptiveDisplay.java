package rtu.group.adaptive.renthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AdaptiveDisplay extends AppCompatActivity {

    private String min_price, max_price, num_rooms, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptive_display);

        Intent intent = getIntent();
        num_rooms = intent.getStringExtra("Number_rooms");
        min_price = intent.getStringExtra("Minimum_price");
        max_price = intent.getStringExtra("Maximum_price");
        city = intent.getStringExtra("City");

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.setAdaptiveParameters(Integer.parseInt(num_rooms), Integer.parseInt(min_price), Integer.parseInt(max_price), city);
        backgroundTask.execute("get_adaptive");
    }
}
