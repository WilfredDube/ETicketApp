package com.unbusy.e_ticketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    private static MyTicket
    private static final String TAG = "MainActivity";

    // e531 lenovo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: MAIN ACTIVITY");
        setContentView(R.layout.activity_sign_in);

        Button signInBtn = findViewById(R.id.signInBtn);
        final TextView textViewUsername = findViewById(R.id.login_email_edt);
        TextView textNoAccnt = findViewById(R.id.textNoAccnt);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TrainListActivity.class);
                intent.putExtra("username", textViewUsername.getText());
                startActivity(intent);
            }
        });

        textNoAccnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });

    }
}
