package com.unbusy.e_ticketapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class PaymentSummaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        Toolbar toolbar	= findViewById(R.id.topPanel);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite, null));
        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        final TripData tripData = (TripData) intent.getSerializableExtra("trip_data");
        final TrainData trainData = (TrainData) intent.getSerializableExtra("train_data");
        final String paymentSummary = intent.getStringExtra("payment_summary");

        ImageView imageView = findViewById(R.id.imgQRCode);
        TextView textSourcePaid = findViewById(R.id.textSourcePaid);
        TextView textDestinationPaid = findViewById(R.id.textDestinationPaid);
        TextView textBoardingPaid = findViewById(R.id.textBoardingPaid);
        TextView textDropPaid = findViewById(R.id.textDropPaid);
        TextView textTicketDetails = findViewById(R.id.textTicketDetails);
        Button doneBtn = findViewById(R.id.doneBtn);
        Button bookAgainBtn = findViewById(R.id.bookagainBtn);

        textSourcePaid.setText(tripData.getFromPlace());
        textDestinationPaid.setText(tripData.getToPlace());
        textBoardingPaid.setText(tripData.getBoardingPoint().getStName());
        textDropPaid.setText(tripData.getDropOffPoint().getStName());
        textTicketDetails.setText(paymentSummary);

        final int imgResourceId = (R.drawable.sucess_icon);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(PaymentSummaryActivity.this, TicketDetailsActivity.class);
                intent2.putExtra("trip_Data", tripData);
                intent2.putExtra("payment_summary", paymentSummary);
                intent2.putExtra("success_img", imgResourceId);
                startActivity(intent2);
            }
        });

        bookAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PaymentSummaryActivity.this, TrainListActivity.class);
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
