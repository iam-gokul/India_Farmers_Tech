package com.ift.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

public class Purchase extends AppCompatActivity implements PaymentResultWithDataListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startpayment(10);

            }
        });


    }

    private void startpayment(int cash) {
        Checkout checkout = new Checkout();

        checkout.setImage(R.drawable.ic_launcher_foreground);
        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();


            options.put("name", "IndiaFarm.Tech");


            options.put("description", "Reference No. #123456");
            options.put("currency", "INR");


            options.put("amount",cash*100);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("Shuttt", "Error in starting Razorpay Checkout", e);
        }
    }


    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        Toast.makeText(this, "Payment Successfull for " , Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(this, "Payment Error " + s, Toast.LENGTH_SHORT).show();
        Log.d("Shuttt",s);
    }

}
