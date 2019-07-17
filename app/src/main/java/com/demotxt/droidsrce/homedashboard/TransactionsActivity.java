package com.demotxt.droidsrce.homedashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class TransactionsActivity extends AppCompatActivity {
    CardView mDeposit,mWithdraw,mBalance,mTaggedTrans,mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        mDeposit = (CardView) findViewById(R.id.cardDeposit);
        mWithdraw = (CardView) findViewById(R.id.cardWthdraw);
        mBalance = (CardView) findViewById(R.id.cardAccountbalance);
        mTaggedTrans = (CardView) findViewById(R.id.cardTaggedtransactions);
        mAbout = (CardView) findViewById(R.id.cardAbout);

        mDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deposit=new Intent(TransactionsActivity.this, LoginActivity.class);
                deposit.putExtra("transactionName", "Deposit");
                startActivity(deposit);
            }
        });
        mWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deposit=new Intent(TransactionsActivity.this, LoginActivity.class);
                deposit.putExtra("transactionName", "Withdrawal");
                startActivity(deposit);
            }
        });
        mBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deposit=new Intent(TransactionsActivity.this, LoginActivity.class);
                deposit.putExtra("transactionName", "Checked Balance");
                startActivity(deposit);
            }
        });
        mTaggedTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deposit=new Intent(TransactionsActivity.this, LoginActivity.class);
                deposit.putExtra("transactionName", "Checked Tagged Transactions");
                startActivity(deposit);
            }
        });

    }
}
