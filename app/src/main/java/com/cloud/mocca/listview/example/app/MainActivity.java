package com.cloud.mocca.listview.example.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    final static int LIST_VIEW=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //start the list activity
            Intent myIntent = new Intent(this, ListViewJFile.class);
            //need an ID to decide which activity is launched
            startActivityForResult(myIntent, LIST_VIEW);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //callback for closed secondary activities
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //is this from ListView activity?
        if (requestCode == LIST_VIEW) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("result");
                Toast toast= Toast.makeText(MainActivity.this, "you selected " + result,Toast.LENGTH_LONG);
                toast.show();
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
                Toast toast= Toast.makeText(MainActivity.this, "you canceled selection",Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }//onActivityResult
}
