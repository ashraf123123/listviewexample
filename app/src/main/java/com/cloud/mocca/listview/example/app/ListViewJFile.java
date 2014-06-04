package com.cloud.mocca.listview.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListActivity;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vanavah on 6/3/2014.
 */
public class ListViewJFile extends ListActivity {

    static final String[] bibles = new String[]{"New World Translation 2013", "New World Translation 1984", "Revised New King James Version", "New International Version"};

    ArrayAdapter<String> listAdapter;
    String result="";
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for a listview activity you MUST use a TextViewt
        textView =(TextView)findViewById(R.id.mainListView);

        // Create and populate a List of p lanet names.
        ArrayList<String> biblesList = new ArrayList<String>();
        biblesList.addAll(Arrays.asList(bibles));

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, biblesList);

        // Set the ArrayAdapter as the ListView's adapter.
        //textView.setAdapter(listAdapter);   //not valid for a ListViewActivity

        // Assign adapter to ListView
        setListAdapter(listAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        // ListView Clicked item index
        int itemPosition     = position;

        // ListView Clicked item value
        String  itemValue    = (String) l.getItemAtPosition(position);

        result=itemValue;

        Toast toast=Toast.makeText(ListViewJFile.this, "Click : \n  Position :" + itemPosition + "  \n  ListItem : " + itemValue, Toast.LENGTH_LONG);
        //textView.setText("Click : \n  Position :" + itemPosition + "  \n  ListItem : " + itemValue);
        toast.show();
        closeMe();
    }
    @Override
    public void onBackPressed(){
        cancelMe();
    }
    void closeMe(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
    void cancelMe(){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }
}
