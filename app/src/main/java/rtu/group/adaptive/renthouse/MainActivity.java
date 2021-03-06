package rtu.group.adaptive.renthouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
 *   Created by Doston Hamrakulov
 */
public class MainActivity extends AppCompatActivity {

    DefaultValues defaultValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultValues = new DefaultValues();
    }
    public void Staring(View view){

        startActivity(new Intent(MainActivity.this, Starter.class));
    }
    public void DownloadData(View view){
        for(int i = 0; i < 23; i++){
            BackgroundTask backgroundTask= new BackgroundTask(this);
            backgroundTask.execute("add_info", defaultValues.getCITY(i), defaultValues.getNUM_ROOMS(i),
                    defaultValues.getPRICE(i), defaultValues.getMIN_PERIOD(i), defaultValues.getFLOOR(i),
                    defaultValues.getADDRESSES(i), defaultValues.getPHONES(i));
        }
        Toast.makeText(MainActivity.this, "Database is updated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

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
        if (id == R.id.id_user_house) {
            startActivity(new Intent(MainActivity.this, Inserting.class));
            return true;
        }
        switch(id){
            case R.id.id_about_using:
                aboutMe();
                return true;
            case R.id.id_exit_app_home:
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
                        Toast.makeText(MainActivity.this, "Good bye!!!", Toast.LENGTH_SHORT).show();
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

    public void aboutMe(){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage("This app has been developed for fun, not commercial purpose!\n\n" +
                "Developer: Doston\n" +
                "Email: doston2509@gmail.com")
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
