package com.unbusy.e_ticketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class TicketDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details);

        Toolbar toolbar	= findViewById(R.id.topPanel);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite, null));
        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        final TripData tripData = (TripData) intent.getSerializableExtra("trip_data");
        final TrainData trainData = (TrainData) intent.getSerializableExtra("train_data");
        final String paymentSummary = intent.getStringExtra("payment_summary");
//        final int imgrs = parseInt(intent.getStringExtra("success_img"));

        ImageView imageView = findViewById(R.id.imgQRCode);
        TextView ticketSuccessIcon = findViewById(R.id.textTicketDetails);

        ticketSuccessIcon.setText(paymentSummary);
        imageView.setImageResource(R.drawable.valid_ticket_image);
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
