package com.androidmidtermtest.electricitybillapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.androidmidtermtest.electricitybillapplication.Model.ElectricityBillInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ElectricityBillActivity extends AppCompatActivity {

    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.txtAccountNumber)
    TextView txtAccountNumber;
    @BindView(R.id.edtAccountNumber)
    EditText edtAccountNumber;
    @BindView(R.id.txtMeterNumber)
    TextView txtMeterNumber;
    @BindView(R.id.edtMeterNumber)
    EditText edtMeterNumber;
    @BindView(R.id.txtStep1)
    TextView txtStep1;
    @BindView(R.id.txtUsage)
    TextView txtUsage;
    @BindView(R.id.txtMonthlyUsage)
    TextView txtMonthlyUsuage;
    @BindView(R.id.edtMonthlyUsage)
    EditText edtMonthlyUsage;
    @BindView(R.id.txtKWH)
    TextView txtKWH;
    @BindView(R.id.txtPricingPlan)
    TextView txtPricingPlan;
    @BindView(R.id.rbTimeOfUsePricing)
    RadioButton rbTimeOfUsePricing;
    @BindView(R.id.rbTieredPricing)
    RadioButton rbTieredPricing;
    @BindView(R.id.rgPlanSelect)
    RadioGroup rgPlanSelect;
    @BindView(R.id.txtAdjustConsumption)
    TextView txtAdjustConsumption;
    @BindView(R.id.edtOffPeak)
    EditText edtOffPeak;
    @BindView(R.id.edtMidPeak)
    EditText edtMidPeak;
    @BindView(R.id.edtOnPeak)
    EditText edtOnPeak;
    @BindView(R.id.linearConsumption)
    LinearLayout linearConsumption;
    @BindView(R.id.txtStep2)
    TextView txtStep2;
    @BindView(R.id.txtOESP)
    TextView txtOESP;
    @BindView(R.id.txtOESPCredit)
    TextView txtOESPCredit;
    @BindView(R.id.edtOESPCredit)
    EditText edtOESPCredit;
    @BindView(R.id.txtOptional)
    TextView txtOptional;
    @BindView(R.id.txtContractRetailer)
    TextView txtContractRetailer;
    @BindView(R.id.txtContractRate)
    TextView txtContractRate;
    @BindView(R.id.edtContractRate)
    EditText edtContractRate;
    @BindView(R.id.txtCKWH)
    TextView txtCKWH;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    public ElectricityBillActivity() {
    }

    ElectricityBillInfo electricityBillInfoObj = new ElectricityBillInfo();
    Bundle b = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill);
        ButterKnife.bind(this);
        linearConsumption.setVisibility(View.GONE);
    }

    @OnClick({R.id.rbTimeOfUsePricing, R.id.rbTieredPricing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbTimeOfUsePricing:
                linearConsumption.setVisibility(View.VISIBLE);
                electricityBillInfoObj.setPricePlan("Time-of-use-Pricing");
                break;
            case R.id.rbTieredPricing:
                linearConsumption.setVisibility(View.GONE);
                electricityBillInfoObj.setPricePlan("Tiered Pricing");
                break;
        }
    }

    @OnClick(R.id.btnLogin)
    public void onBtnClicked() {

        populateDataInModel();
        if ((Integer.parseInt(edtOffPeak.getText().toString())+Integer.parseInt(edtMidPeak.getText().toString())+Integer.parseInt(edtOnPeak.getText().toString())) == 100) {
            b.putSerializable("BillDetails", electricityBillInfoObj);
            startIntent(ElectricityBillActivity.this, b);
        }else
            {
                Toast.makeText(ElectricityBillActivity.this, "Incorrect value Input of Consumption, Sum should be 100, Try Again", Toast.LENGTH_LONG).show();
            }
    }

    public static void startIntent(Context context) {
        context.startActivity(new Intent(context, FinalBillActivity.class));
    }

    public static void startIntent(Context context, Bundle bundle) {
        Intent mIntent = new Intent(context, FinalBillActivity.class);
        mIntent.putExtras(bundle);
        context.startActivity(mIntent);
    }

    private void populateDataInModel() {
        electricityBillInfoObj.setName(edtName.getText().toString());
        electricityBillInfoObj.setAccountNumber(edtAccountNumber.getText().toString());
        electricityBillInfoObj.setMeterNumber(Integer.parseInt(edtMeterNumber.getText().toString()));
        electricityBillInfoObj.setMonthlyUsage(Double.parseDouble(edtMonthlyUsage.getText().toString()));
        electricityBillInfoObj.setConsumptionOffPeak(Integer.parseInt(edtOffPeak.getText().toString()));
        electricityBillInfoObj.setConsumptionMidPeak(Integer.parseInt(edtMidPeak.getText().toString()));
        electricityBillInfoObj.setConsumptionOnPeak(Integer.parseInt(edtOnPeak.getText().toString()));
        electricityBillInfoObj.setOESPCredit(Double.parseDouble(edtOESPCredit.getText().toString()));
        electricityBillInfoObj.setContractRate(Double.parseDouble(edtContractRate.getText().toString()));
        electricityBillInfoObj.setCalculateTiredPricingTotal(calculateTiredPricingTotal());
        electricityBillInfoObj.setCalculateTimeOfUsePricingTotal(calculateTimeOfUsePricingTotal());
        electricityBillInfoObj.setDelivery(delivery());
        electricityBillInfoObj.setRegulatoryCharge(regulatoryCharge());
        electricityBillInfoObj.setHst(hst());
        electricityBillInfoObj.setProvincialRebate(provincialRebate());
        electricityBillInfoObj.setGlobalAdjustment(globalAdjustment());
        electricityBillInfoObj.setTotalAmount(totalAmount());

    }
    private double calculateTiredPricingTotal(){
        Double monthlyUsage = Double.parseDouble(edtMonthlyUsage.getText().toString());
        double total=0.0;
        if(monthlyUsage <= 600){
            total = (monthlyUsage * 7.7)/100;
        }else if(monthlyUsage > 600){
            total = (((monthlyUsage - 600) * 8.9)/100) + (600 * 7.7)/100;
        }
        return total;
    }

    public double calculateTimeOfUsePricingTotal() {
        double total = 0.0;
        int offPeak = Integer.parseInt(edtOffPeak.getText().toString());
        int midPeak = Integer.parseInt(edtMidPeak.getText().toString());
        int onPeak = Integer.parseInt(edtOnPeak.getText().toString());
        double monthlyUsage = Double.parseDouble(edtMonthlyUsage.getText().toString());
        double offPeakTotal = ((offPeak/100) * monthlyUsage * 6.5)/100;
        double midPeakTotal = ((midPeak/100) * monthlyUsage * 9.4)/100;
        double onPeakTotal= ((onPeak/100) * monthlyUsage * 13.2)/100;
        total = (offPeakTotal +midPeakTotal + onPeakTotal);
    return total;
    }
    public double delivery(){
        double delievry = 0.0;
        return delievry;
    }

    public double regulatoryCharge(){
        double regulatoryCharge = 0.0;
        return regulatoryCharge;
    }

    public double hst(){
        double hst = 0.0;
        return hst;
    }

    public double provincialRebate(){
        double provincialRebate = 0.0;
        return provincialRebate;
    }

    public double globalAdjustment(){
        double globalAdjustment = 0.0;
        return globalAdjustment;
    }

    public double totalAmount(){
        double totalAmount = 0.0;
        return totalAmount;
    }
}
