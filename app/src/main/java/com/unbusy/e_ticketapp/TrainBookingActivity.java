package com.unbusy.e_ticketapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class TrainBookingActivity extends AppCompatActivity {
    private static final String TAG = "TrainBookingActivity";
    private TripData tripData;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Train Booking");
        setContentView(R.layout.activity_train_booking);

        Toolbar toolbar	= findViewById(R.id.topPanel);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite, null));
        setSupportActionBar(toolbar);

        Button bookBtn = findViewById(R.id.bookingDoneBtn);
        final EditText edtNoOfPassengers = findViewById(R.id.edtNoOfPassengers);

        Intent intent = getIntent();
        final TrainData trainData = (TrainData) intent.getSerializableExtra("train_data");

        TextView textFromPlace = findViewById(R.id.textFromPlace);
        textFromPlace.setText(trainData.getFromPlace());

        TextView textToPlace = findViewById(R.id.textToPlace);
        textToPlace.setText(trainData.getToPlace());

        TextView textCompartmentType = findViewById(R.id.textCompartmentType);
        textCompartmentType.setText(trainData.getCompartmentType());

        final TextView textDepartureDate = findViewById(R.id.textDepartureDate);
        tripData = new TripData();

        textDepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        TrainBookingActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 += 1;
                String date = i2 +"/" + i1 + "/" + i;
                textDepartureDate.setTextColor(getResources().getColor(R.color.appColor, null));
                textDepartureDate.setText(date);
                tripData.setDepartureDate(date);
            }
        };

        tripData.setTrainName(trainData.getTrainName());
        tripData.setDepartureTime(trainData.getDepartureTime());
        tripData.setArrivalTime(trainData.getArrivalTime());
        tripData.setFromPlace(trainData.getFromPlace());
        tripData.setToPlace(trainData.getToPlace());

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripData.setNumberOfPassengers(parseInt(edtNoOfPassengers.getText().toString()));
                tripData.setDepartureDate(textDepartureDate.getText().toString());
                tripData.setCompartmentType(trainData.getCompartmentType());
                tripData.setTripCost(trainData.getTripCost());

                Intent intent = new Intent(TrainBookingActivity.this, SelectStationsActivity.class);
                intent.putExtra("trip_data", tripData);
                intent.putExtra("train_data", trainData);

                Log.d(TAG, "onClick: " + tripData.getTrainName());
                startActivity(intent);
            }
        });

        // TODO: generate seat numbers
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
