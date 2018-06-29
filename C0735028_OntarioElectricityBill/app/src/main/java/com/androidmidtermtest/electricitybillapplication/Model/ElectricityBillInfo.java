package com.androidmidtermtest.electricitybillapplication.Model;

import java.io.Serializable;

public class ElectricityBillInfo implements Serializable{
    String name;
    String accountNumber;
    int meterNumber;
    double monthlyUsage;
    String pricePlan;
    int consumptionOffPeak;
    int consumptionMidPeak;
    int consumptionOnPeak;
    double OESPCredit;
    double contractRate;

    double calculateTiredPricingTotal;
    double calculateTimeOfUsePricingTotal;
    double delivery;
    double regulatoryCharge;
    double hst;
    double provincialRebate;
    double totalAmount;
    double globalAdjustment;


    public  ElectricityBillInfo()
    {
        //default constructor
    }

    public ElectricityBillInfo(String name, String accountNumber, int meterNumber, Double monthlyUsage, String pricePlan, int consumptionOffPeak, int consumptionMidPeak, int consumptionOnPeak, double OESPCredit, double contractRate, double totalBillPrice) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.meterNumber = meterNumber;
        this.monthlyUsage = monthlyUsage;
        this.pricePlan = pricePlan;
        this.consumptionOffPeak = consumptionOffPeak;
        this.consumptionMidPeak = consumptionMidPeak;
        this.consumptionOnPeak = consumptionOnPeak;
        this.OESPCredit = OESPCredit;
        this.contractRate = contractRate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(int meterNumber) {
        this.meterNumber = meterNumber;
    }

    public double getMonthlyUsage() {
        return monthlyUsage;
    }

    public void setMonthlyUsage(double monthlyUsage) {
        this.monthlyUsage = monthlyUsage;
    }

    public String getPricePlan() {
        return pricePlan;
    }

    public void setPricePlan(String pricePlan) {
        this.pricePlan = pricePlan;
    }

    public int getConsumptionOffPeak() {
        return consumptionOffPeak;
    }

    public void setConsumptionOffPeak(int consumptionOffPeak) {
        this.consumptionOffPeak = consumptionOffPeak;
    }

    public int getConsumptionMidPeak() {
        return consumptionMidPeak;
    }

    public void setConsumptionMidPeak(int consumptionMidPeak) {
        this.consumptionMidPeak = consumptionMidPeak;
    }

    public int getConsumptionOnPeak() {
        return consumptionOnPeak;
    }

    public void setConsumptionOnPeak(int getConsumptionOnPeak) {
        this.consumptionOnPeak = getConsumptionOnPeak;
    }

    public double getOESPCredit() {
        return OESPCredit;
    }

    public void setOESPCredit(double OESPCreadit) {
        this.OESPCredit = OESPCreadit;
    }

    public double getContractRate() {
        return contractRate;
    }

    public void setContractRate(double contractRate) {
        this.contractRate = contractRate;
    }

    public double getCalculateTiredPricingTotal() {
        return calculateTiredPricingTotal;
    }

    public void setCalculateTiredPricingTotal(double calculateTiredPricingTotal) {
        this.calculateTiredPricingTotal = calculateTiredPricingTotal;
    }
    public double getCalculateTimeOfUsePricingTotal() {
        return calculateTimeOfUsePricingTotal;
    }

    public void setCalculateTimeOfUsePricingTotal(double calculateTimeOfUsePricingTotal) {
        this.calculateTimeOfUsePricingTotal = calculateTimeOfUsePricingTotal;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    public double getRegulatoryCharge() {
        return regulatoryCharge;
    }

    public void setRegulatoryCharge(double regulatoryCharge) {
        this.regulatoryCharge = regulatoryCharge;
    }

    public double getHst() {
        return hst;
    }

    public void setHst(double hst) {
        this.hst = hst;
    }

    public double getProvincialRebate() {
        return provincialRebate;
    }

    public void setProvincialRebate(double provincialRebate) {
        this.provincialRebate = provincialRebate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getGlobalAdjustment() {
        return globalAdjustment;
    }

    public void setGlobalAdjustment(double globalAdjustment) {
        this.globalAdjustment = globalAdjustment;
    }
}
