package com.unbusy.e_ticketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectStationsActivity extends AppCompatActivity {
    private static final String TAG = "SelectStationsActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stations);

        Toolbar toolbar	= findViewById(R.id.topPanel);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite, null));
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final TripData tripData = (TripData) intent.getSerializableExtra("trip_data");
        final TrainData trainData = (TrainData) intent.getSerializableExtra("train_data");

        final ListView stationList = findViewById(R.id.stationList);
        TextView textCost = findViewById(R.id.textCost);
        textCost.setText(String.format("$%.2f", tripData.getTripCost()));
        final Button bookingDoneBtn = findViewById(R.id.bookingDoneBtn);
        bookingDoneBtn.setVisibility(View.INVISIBLE);

        Station station1 = new Station("NRZ Bulwayo Main", "Bulawayo", "Bulawayo", "Bulawayo");
        Station station2 = new Station("Ngamo", "Mat North", "Bulawayo", "Hwange");
        Station station3 = new Station("Mpopoma", "Bulawayo", "Bulawayo", "Bulawayo");
        Station station4 = new Station("Luveve", "Bulawayo", "Bulawayo", "Bulawayo");
        Station station5 = new Station("Dete", "Mat North", "Bulawayo", "Hwange");
        Station station6 = new Station("NRZ Hwange", "Hwange", "Bulawayo", "Hwange");

        final ArrayList<Station> stations = new ArrayList<>();

        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        stations.add(station4);
        stations.add(station5);
        stations.add(station6);

        StationListAdapter stationListAdapter = new StationListAdapter(this, R.layout.station_list_item, stations);
        stationList.setAdapter(stationListAdapter);

        Log.d(TAG, "onCreate: " + tripData.getTrainName());

        RadioButton bpRB = findViewById(R.id.boardingPointRB);
        final RadioButton dpRB = findViewById(R.id.dropOffPointRB);

//        bpRB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onCreate: bpRB");
//            }
//        });
//
//        dpRB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onCreate: dpRB");
//            }
//        });

        stationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (tripData.getDropOffPoint() == null && tripData.getBoardingPoint() != null){
                    Log.d(TAG, "Drop-off Point: " + stations.get(i).getStName());
                    tripData.setDropOffPoint(stations.get(i));
                    bookingDoneBtn.setVisibility(View.VISIBLE);
                }

                if (tripData.getBoardingPoint() == null) {
                    Log.d(TAG, "Boarding Point: " + stations.get(i).getStName());
                    tripData.setBoardingPoint(stations.get(i));
                    dpRB.setChecked(true);

                }

//                if (tripData.getDropOffPoint() == null && tripData.getBoardingPoint() != null){
//
//                }

//                Intent intent1 = new Intent(SelectStationsActivity.this, SelectStationsActivity.class);
//                intent1.putExtra("trip_data", tripData);
//                intent1.putExtra("train_data", trainData);
//                startActivity(intent1);
            }
        });
        bookingDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent1 = new Intent(SelectStationsActivity.this, MakePaymentActivity.class);
                    intent1.putExtra("trip_data", tripData);
//                    intent1.putExtra("train_data", trainData);
                    startActivity(intent1);
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
