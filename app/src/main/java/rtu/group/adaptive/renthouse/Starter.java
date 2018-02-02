package rtu.group.adaptive.renthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Starter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void moveInserting(View view){
        startActivity(new Intent(Starter.this, Inserting.class));
    }
    public void moveDisplaying(View view){
        startActivity(new Intent(Starter.this, Displaying.class));
    }
    public void moveSearchHouse(View view){
        startActivity(new Intent(Starter.this, SearchHouse.class));
    }
}
