package com.unbusy.e_ticketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TrainListActivity extends AppCompatActivity {

    private static final String TAG = "TrainListActivity";
    private ListView tripListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: MAIN ACTIVITY");
        setContentView(R.layout.activity_train_list);

        Toolbar toolbar	= findViewById(R.id.topPanel);
        setSupportActionBar(toolbar);

        tripListView = findViewById(R.id.tripListView);

        TrainData tpData1 = new TrainData("NRZ", "(2 x 2) Sleeper", 4, 17, "0700", "1800 ", "Harare", "Bulawayo", 40);
        TrainData tpData2 = new TrainData("Blue Train", "Economy", 40, 7, "0700", "1800 ", "Hwange", "Bulawayo",4);
        TrainData tpData3 = new TrainData("NRZ", "(2 x 2) Sleeper", 4, 17, "0700", "1800 ", "Vic-Falls", "Harare",4);
        TrainData tpData4 = new TrainData("Blue Train", "Economy", 40, 7, "0700", "1800 ", "Hwange", "Bulawayo",13);
        TrainData tpData5 = new TrainData("NRZ", "(2 x 2) Sleeper", 4, 17, "0700", "1800 ", "Masvingo", "Bulawayo",80);
        TrainData tpData6 = new TrainData("Blue Train", "Economy", 40, 7, "0700", "1800 ", "Beitbridge", "Bulawayo",7);

        final ArrayList<TrainData> names = new ArrayList<>();

        names.add(tpData1);
        names.add(tpData2);
        names.add(tpData3);
        names.add(tpData4);
        names.add(tpData5);
        names.add(tpData6);

        TrainListAdapter tpAdapter = new TrainListAdapter(this, R.layout.train_list_item, names);
        tripListView.setAdapter(tpAdapter);

        tripListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + names.get(i).getTrainName());

                Intent intent = new Intent(TrainListActivity.this, TrainBookingActivity.class);
                intent.putExtra("train_data", names.get(i));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.menuBook:
                Intent intent1 = new Intent(this, TrainListActivity.class);
                startActivity(intent1);
                break;
            case R.id.menuTickets:
                break;
            case R.id.menuLogout:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;
        }
        super.onOptionsItemSelected(item);
        return true;
    }
}
