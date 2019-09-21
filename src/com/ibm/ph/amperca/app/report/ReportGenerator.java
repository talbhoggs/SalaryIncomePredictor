package com.ibm.ph.amperca.app.report;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.ibm.ph.amperca.app.bean.DeductionReport;
import com.ibm.ph.amperca.app.bean.IncrementReport;
import com.ibm.ph.amperca.app.interestcalculator.CompoundInterestCalculator;
import com.ibm.ph.amperca.app.utils.ReportUtility;

public class ReportGenerator {
    public static void generate(double principal, int t, int interestInpercent, int n, int interestInprecentDeductions, int m) {
        DecimalFormat df = new DecimalFormat("#.##");
        List<IncrementReport> listOfIreport = new ArrayList<>();
        List<DeductionReport> listOfDreport = new ArrayList<>();
        System.out.println("INCREMENT REPORT");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.format("%7s %17s %23s %17s %17s", "Year", "Starting Salary", "Number of increment", "Increment %", "Increment Amount");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        for(int i=0; i<=t; i++) {
            CompoundInterestCalculator cIc = new CompoundInterestCalculator(principal,interestInpercent, i, n);
            IncrementReport iReport = new IncrementReport(i, cIc.getFutureValue(), n, interestInpercent, cIc.getYearlyReturn());
            listOfIreport.add(iReport);
            System.out.format("%7s %17s %23s %17s %17s", iReport.getYear(), df.format(iReport.getStartingSalary()), ReportUtility.numberToWordCompoundInterestConverter(n), iReport.getIncrement(), df.format(iReport.getIncrementAmount()));
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("DEDUCTION REPORT");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.format("%7s %17s %23s %17s %17s", "Year", "Starting Salary", "Number of deductions", "Deduction %", "Deduction Amount");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        
        listOfIreport.stream().forEachOrdered(iReport->{
            CompoundInterestCalculator cIc = new CompoundInterestCalculator(iReport.getStartingSalary(),interestInprecentDeductions, iReport.getYear(), m);
            DeductionReport dReport = new DeductionReport(iReport.getYear(), cIc.getFutureValue(), m, interestInprecentDeductions, cIc.getYearlyReturn());
            listOfDreport.add(dReport);
            System.out.format("%7s %17s %23s %17s %17s", dReport.getYear(), df.format(iReport.getStartingSalary()), ReportUtility.numberToWordCompoundInterestConverter(m), dReport.getDeduction(), df.format(dReport.getIncrementAmount()));
            System.out.println();
        });

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("PREDICTION REPORT");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.format("%7s %17s %23s %17s %17s", "Year", "Starting Salary", "Increment Amount", "Decrement Amount", "Salary Growth");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        listOfIreport.stream().forEachOrdered(iReport->{
            DeductionReport dReport = listOfDreport.get(iReport.getYear());
            System.out.format("%7s %17s %23s %17s %17s", iReport.getYear(), df.format(iReport.getStartingSalary()), df.format(iReport.getIncrementAmount()), df.format(dReport.getIncrementAmount()), df.format(iReport.getStartingSalary() - dReport.getIncrementAmount()));
            System.out.println();
        });
        System.out.println("-------------------------------------------------------------------------------------");
    }

}
