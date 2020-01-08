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
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MakePaymentActivity extends AppCompatActivity {
    private static final String TAG = "MakePaymentActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);

        Toolbar toolbar	= findViewById(R.id.topPanel);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite, null));
        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        final TripData tripData = (TripData) intent.getSerializableExtra("trip_data");
        final TrainData trainData = (TrainData) intent.getSerializableExtra("train_data");

        TextView textDeptTime = findViewById(R.id.textDeptTime);
        TextView textArriveTime = findViewById(R.id.textArriveTime);
        TextView textTotalTripCost = findViewById(R.id.textTotalTripCost);
        TextView textSource = findViewById(R.id.textSource);
        TextView textDestination = findViewById(R.id.textDestination);
        TextView textDropPt = findViewById(R.id.textDropPt);
        TextView textBoardingPt = findViewById(R.id.textBoardingPt);
        TextView textTicketDetails = findViewById(R.id.textTicketDetails3);
        Button payBtn = findViewById(R.id.payBtn);

        textDeptTime.setText(tripData.getDepartureTime());
        textArriveTime.setText(tripData.getArrivalTime());
        textSource.setText(tripData.getFromPlace());
        textDestination.setText(tripData.getToPlace());
        textDropPt.setText(tripData.getDropOffPoint().getStName());
        textBoardingPt.setText(tripData.getBoardingPoint().getStName());
        textTotalTripCost.setText(String.format("$%.0f", tripData.getTripCost()));


        final String strdetails = "DEPARTING AT " + tripData.getDepartureTime() + "on " + tripData.getDepartureDate() + ", " + tripData.getTrainName() +", " + tripData.getCompartmentType() + " :  Seats - 2A, 2B "+ tripData.getNumberOfPassengers() +" passengers";
        textTicketDetails.setText(strdetails);

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MakePaymentActivity.this, PaymentSummaryActivity.class);
                intent1.putExtra("trip_data", tripData);
                intent1.putExtra("train_data", trainData);
                intent1.putExtra("payment_summary", strdetails);
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