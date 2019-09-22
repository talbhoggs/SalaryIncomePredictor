package com.ibm.ph.amperca.app;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

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
            String input = sc.next();
            while(!ReportUtility.validInput(input)) {
                System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
                input = sc.next();
            }
            salary = Double.parseDouble(input);
        } while(salary < 0);
        System.out.println();

        /* interest section */
        int interest = 0;
        do {
            System.out.print("Please enter the increment to be received (in percent): ");
            String input = sc.next();
            while(!ReportUtility.validInput(input)) {
                System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
                input = sc.next();
            }
            interest = Integer.parseInt(input);
        } while(interest < 0);

        System.out.println();
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
            String input = sc.next();
            while(!ReportUtility.validInput(input)) {
                System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
                input = sc.next();
            }
            incrementRecieved = Integer.parseInt(input);
        } while(incrementRecieved < 0 || incrementRecieved > 4);

        incrementRecieved = ReportUtility.choiceToTrueValueIncrementConverter(incrementRecieved);

        /* interest ducted in percent */
        int interestInprecentDeductions = 0;
        do {
            System.out.print("Please enter the interest to be deducted (in percent): ");
            String input = sc.next();
            while(!ReportUtility.validInput(input)) {
                System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
                input = sc.next();
            }
            interestInprecentDeductions = Integer.parseInt(input);
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
            String input = sc.next();
            while(!ReportUtility.validInput(input)) {
                System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
                input = sc.next();
            }
            deductionRecieved = Integer.parseInt(input);
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
            String input = sc.next();
            while(!ReportUtility.validInput(input)) {
                System.out.printf("\"%s\" is not a valid number.Please provide your input again\n", input);
                input = sc.next();
            }
            period = Integer.parseInt(input);
        } while(period < 0 || period > 4);

        period = ReportUtility.choiceToTrueValuePeriodConverter(period);

        sc.close();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(salary + "\n" + period+ "\n" + interest+ "\n" + incrementRecieved+ "\n" + interestInprecentDeductions+ "\n" + deductionRecieved);
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
