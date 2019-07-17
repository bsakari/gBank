package com.demotxt.droidsrce.homedashboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class BalanceActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ListView mAmount;
    ArrayList<Transaction> balance;
    CustomAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        firebaseAuth = FirebaseAuth.getInstance();
        mAmount = (ListView) findViewById(R.id.tvAmount);
        balance = new ArrayList<>();
        adapter = new CustomAdapter(this,balance);
        mAmount.setAdapter(adapter);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Checking Balance");
        dialog.setMessage("Please wait");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("AccountNumber");
        dialog.show();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:dataSnapshot.getChildren()){
                    Transaction cash = snap.getValue(Transaction.class);
                    balance.add(cash);
                }
                Collections.reverse(balance);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(BalanceActivity.this, "Database Locked", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void home(View view) {
        firebaseAuth.signOut();
        startActivity(new Intent(getApplicationContext(),TransactionsActivity.class));
        finish();
    }
}
