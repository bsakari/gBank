package com.demotxt.droidsrce.homedashboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DepositActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText mAmount;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        firebaseAuth = FirebaseAuth.getInstance();
        mAmount = (EditText) findViewById(R.id.edtAmount);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Depositing");
        dialog.setTitle("Please wait!!!");


    }

    public void home(View view) {
        firebaseAuth.signOut();
        startActivity(new Intent(getApplicationContext(),TransactionsActivity.class));
        finish();
    }

    public void deposit(View view) {


        String amount = mAmount.getText().toString();
        long time = System.currentTimeMillis();
        if (amount.isEmpty()){
            System.out.println("Enter amount");
        }else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("AccountNumber/"+time);
            Transaction transaction = new Transaction(amount,String.valueOf(time));
            dialog.show();
            ref.setValue(transaction).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    dialog.dismiss();
                    if (task.isSuccessful()){
                        Toast.makeText(DepositActivity.this, "Deposit Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(DepositActivity.this, "Depositing failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
