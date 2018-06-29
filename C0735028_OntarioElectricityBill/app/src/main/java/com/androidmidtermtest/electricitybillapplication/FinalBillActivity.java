package com.androidmidtermtest.electricitybillapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.androidmidtermtest.electricitybillapplication.Model.ElectricityBillInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinalBillActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.txtPutAccountNumber)
    TextView txtPutAccountNumber;
    @BindView(R.id.txtPutMeterNumber)
    TextView txtPutMeterNumber;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.textView12)
    TextView textView12;
    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.txtPutOffPeak)
    TextView txtPutOffPeak;
    @BindView(R.id.txtPutMidPeak)
    TextView txtPutMidPeak;
    @BindView(R.id.txtPutOnPeak)
    TextView txtPutOnPeak;
    @BindView(R.id.txtDelivery)
    TextView txtDelivery;
    @BindView(R.id.txtPutDelivery)
    TextView txtPutDelivery;
    @BindView(R.id.txtTotalElectricityCharge)
    TextView txtTotalElectricityCharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_bill);
        ButterKnife.bind(this);
        ElectricityBillInfo billDetails = (ElectricityBillInfo) getIntent().getSerializableExtra("BillDetails");
        txtPutAccountNumber.setText(billDetails.getAccountNumber());
        txtPutMeterNumber.setText(billDetails.getMeterNumber());

        Toast.makeText(FinalBillActivity.this, "Name: " + billDetails.getName().toString(), Toast.LENGTH_LONG).show();
        int age = getIntent().getIntExtra("Age", 0);
        Toast.makeText(this, "Age" + age, Toast.LENGTH_LONG).show();
    }
}
