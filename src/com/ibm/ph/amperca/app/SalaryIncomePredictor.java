package com.ibm.ph.amperca.app;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.ibm.ph.amperca.app.report.ReportGenerator;
import com.ibm.ph.amperca.app.utils.ReportUtility;

public class SalaryIncomePredictor {

    public void generateReport() {

        renderBannerPage();
        Scanner sc = new Scanner(System.in);
        double salary = 0.0;

        /* salary section */
        do {
            System.out.print("Please enter your Salary: ");
            while(!sc.hasNextDouble()) {
                String s = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", s);
                System.out.println("input should be a positive number");
            }
            salary = sc.nextDouble();
        } while(salary < 0);

        System.out.println();
        int interest = 0;

        /* interest section */
        do {
            System.out.print("Please enter the increment to be received (in percent): ");
            while (!sc.hasNextInt()) {
                String s = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", s);
                System.out.println("input should be a positive number");
            }
            interest = sc.nextInt();
        } while(interest < 0);

        System.out.println();

        /* interest frequency section */
        int incrementRecieved = 0;
        do {
            System.out.print("Please enter the frequency to be received: ");
            System.out.println();
            System.out.println("[1] Monthly");
            System.out.println("[2] Quarterly");
            System.out.println("[3] Half-yearly");
            System.out.println("[4] Yearly");
            System.out.println();
            System.out.println("Example: 1 for Monthly");

            while (!sc.hasNextInt()) {
                String s = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", s);
                System.out.println("input should be on the given choices above");
            }
            incrementRecieved = sc.nextInt();

        } while(incrementRecieved < 0 || incrementRecieved > 4);

        incrementRecieved = ReportUtility.choiceToTrueValueIncrementConverter(incrementRecieved);
        /* interest ducted in percent */
        int interestInprecentDeductions = 0;
        do {
            System.out.print("Please enter the interest to be deducted (in percent): ");
            while (!sc.hasNextInt()) {
                String s = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", s);
                System.out.println("input should be a positive number");
            }
            interestInprecentDeductions = sc.nextInt();
        } while(interestInprecentDeductions < 0);

        System.out.println();

        /* frequence of deduction section */
        int deductionRecieved = 0;
        do {
            System.out.print("Please enter the frequency the deductions done: ");
            System.out.println();
            System.out.println("[1] Monthly");
            System.out.println("[2] Quarterly");
            System.out.println("[3] Half-yearly");
            System.out.println("[4] Yearly");
            System.out.println();
            System.out.println("Example: 1 for Monthly");
            while (!sc.hasNextInt()) {
                String s = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", s);
                System.out.println("input should be on the given choices above");
            }
            deductionRecieved = sc.nextInt();
        } while(deductionRecieved < 0 || deductionRecieved > 4);

        deductionRecieved = ReportUtility.choiceToTrueValueIncrementConverter(deductionRecieved);

        /* period section */
        int period = 0;
        do {
            System.out.print("Please enter the period of time");
            System.out.println();
            System.out.println("[1] 5 years");
            System.out.println("[2] 10 years");
            System.out.println("[3] 20 years");
            System.out.println("[4] 30 years");
            System.out.println();
            System.out.println("Example: 5 for years");

            while (!sc.hasNextInt()) {
                String s = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", s);
                System.out.println("input should be on the given choices above");
            }
            period = sc.nextInt();

        } while(period < 0 || period > 4);
        period = ReportUtility.choiceToTrueValuePeriodConverter(period);

        sc.close();

        System.out.println();
        System.out.println();
        System.out.println();
        ReportGenerator.generate(salary, period, interest, incrementRecieved, interestInprecentDeductions, deductionRecieved);

    }

    private static void renderBannerPage() {
        System.out.println("+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+ +-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+");
        System.out.format("%84s","|S|a|l|a|r|y| |I|n|c|o|m|e| |P|r|e|d|i|c|t|o|r|\n");
        System.out.println("+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+ +-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+\n");
        System.out.format("%84s","Submitted By: Charles Amper\n");
        System.out.format("%84s","Assignment 4: IIHTIBM\n");
        System.out.format("%84s","amperca@ph.ibm.com\n\n");
        System.out.println("+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+ +-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+\n\n\n\n");
    }

    public static void main(String[] args) {
        SalaryIncomePredictor sIp = new SalaryIncomePredictor();
        sIp.generateReport();
    }
}
