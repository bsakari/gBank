package com.demotxt.droidsrce.homedashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class TaggedtransActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taggedtrans);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void home(View view) {
        firebaseAuth.signOut();
        startActivity(new Intent(getApplicationContext(),TransactionsActivity.class));
        finish();
    }
}
