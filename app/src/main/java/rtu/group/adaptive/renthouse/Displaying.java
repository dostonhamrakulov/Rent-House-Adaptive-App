package rtu.group.adaptive.renthouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Displaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying);

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_info");
    }
}
