package rtu.group.adaptive.renthouse;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/*
 *   Created by Doston Hamrakulov
 */
public class Inserting extends AppCompatActivity {

    EditText number_rooms, price, floors, period, address, phone;
    Spinner cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);

        number_rooms = (EditText)findViewById(R.id.edit_rooms);
        price = (EditText)findViewById(R.id.edit_price);
        period = (EditText)findViewById(R.id.edit_period);
        address = (EditText)findViewById(R.id.edit_address);
        phone = (EditText)findViewById(R.id.edit_phone);
        cities = (Spinner) findViewById(R.id.edit_city);
        floors = (EditText)findViewById(R.id.edit_floor);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void AddData(View view){
//        myDatabaseHelper.insertData(name1.getText().toString(), ranking1.getText().toString(),
//                fee1.getText().toString(), program1.getText().toString(), city1.getText().toString(),
//                country1.getText().toString(), continent1.getText().toString());

        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute("add_info", cities.getSelectedItem().toString(), number_rooms.getText().toString(),
                price.getText().toString(), period.getText().toString(), floors.getText().toString(),
                address.getText().toString(), phone.getText().toString());

        Toast.makeText(Inserting.this, "New data inserted!", Toast.LENGTH_LONG).show();

        //cities.setText("");
        number_rooms.setText("");
        price.setText("");
        period.setText("");
        floors.setText("");




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_action, menu);

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            universalBox("Sorry, there is no any option for setting!!!");
            return true;
        }
        switch(id){
            case R.id.id_about_us:
                universalBox("This app has been developed for fun, not commercial purpose!\n\n" +
                        "Developer: Doston\n" +
                        "Email: doston2509@gmail.com");
                return true;
            case R.id.id_contact_us:
                universalBox("Website: idoston.com\n" +
                        "Email: doston2509@gmail.com");
                return true;
            case R.id.id_exit_app:
                Exit_alert();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Exit_alert(){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage("Do you want to close this app?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Inserting.this, "Good bye!!!", Toast.LENGTH_SHORT).show();
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = alert_builder.create();
        alert.setTitle("Alert!!!");
        alert.show();
    }

    public void universalBox(String msg){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog alert = alert_builder.create();
        alert.show();
    }
}
