package com.ibm.ph.amperca.app.interestcalculator;
import java.text.DecimalFormat;

public class CompoundInterestCalculator {
    
    private double principal = 0.0;
    private double interest = 0;
    private int period = 0;
    private int compoundInterval = 0;
    private double interestDeduction = 0;
    private int compoundIntervalDeduction= 0;

    public double getInterestDeduction() {
        return interestDeduction;
    }


    public void setInterestDeduction(double interestDeduction) {
        this.interestDeduction = interestDeduction;
    }


    public int getCompoundIntervalDeduction() {
        return compoundIntervalDeduction;
    }


    public void setCompoundIntervalDeduction(int compoundIntervalDeduction) {
        this.compoundIntervalDeduction = compoundIntervalDeduction;
    }


    public CompoundInterestCalculator(double principal, int interest, int period, int compoundInterval) {
        this.setPrincipal(principal);
        this.setInterest(interest);
        this.setPeriod(period);
        this.setCompoundInterval(compoundInterval);
    }


    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = calculateInterest(interest);
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCompoundInterval() {
        return compoundInterval;
    }

    public void setCompoundInterval(int compoundInterval) {
        this.compoundInterval = compoundInterval;
    }
    
    public double getFutureValue() {
        return calculateCompoundInterest();
    }
    
    public double getYearlyReturn() {
        return (this.getFutureValue() - this.getPrincipal());
    }
    
    private double calculateCompoundInterest() {
        double result = this.getPrincipal()*Math.pow((1 + (this.getInterest()/this.getCompoundInterval())),(this.getCompoundInterval()*this.getPeriod()));
        return Double.valueOf(result);
    }
    
    private double calculateInterest(int interestInpercent) {
        return Double.valueOf(interestInpercent)/100;
    }

}
