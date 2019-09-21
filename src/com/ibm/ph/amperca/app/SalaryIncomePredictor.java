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

        // Salary section
        System.out.print("Please enter your Salary: ");
        boolean isValidSalary = false;
        do {

            salary = sc.nextDouble();

            while(salary < 0) {
                System.out.println("Please enter a valid number input");
                salary = sc.nextDouble();
            }

            isValidSalary = true;

        } while(!isValidSalary);

        System.out.println();
        System.out.print("Please enter the increment to be received (in percent): ");

        int interest;

        // interest section
        boolean isValidInterest = false;
        do {
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number input should be greated than 1");
                sc.next();
            }

            interest = sc.nextInt();

            while (interest < 0) {
                System.out.println("Please enter a valid number input should be greated than 1");
                interest = sc.nextInt();
            }

            isValidInterest = true;
        }while(!isValidInterest);

        // interest frequency
        System.out.println();
        System.out.print("Please enter the frequency to be received: ");
        System.out.println();
        System.out.println("[1] Monthly");
        System.out.println("[2] Quarterly");
        System.out.println("[3] Half-yearly");
        System.out.println("[4] Yearly");
        System.out.println();
        System.out.println("Example: 1 for Monthly");

        int incrementRecieved;
        boolean isValidIncrementRecieved = false;
        do {

            incrementRecieved = sc.nextInt();

            while (incrementRecieved < 0 || incrementRecieved > 4) {
                System.out.println("Please enter a valid number input should be greated than 1");
                incrementRecieved = sc.nextInt();
            }

            incrementRecieved = ReportUtility.choiceToTrueValueIncrementConverter(incrementRecieved);
            isValidIncrementRecieved = true;
        } while(!isValidIncrementRecieved);

        // interest ducted in percent
        System.out.print("Please enter the interest to be deducted (in percent): ");
        
        int interestInprecentDeductions;
        boolean isValidInterestInprecentDeductions = false;
        do {

            interestInprecentDeductions = sc.nextInt();
            while (interestInprecentDeductions < 0) {
                System.out.println("Please enter a valid number input should be greated than 1");
                interestInprecentDeductions = sc.nextInt();
            }
            isValidInterestInprecentDeductions = true;
        } while(!isValidInterestInprecentDeductions);

        System.out.println();

        // frequence of deduction
        System.out.print("Please enter the frequency the deductions done: ");
        System.out.println();
        System.out.println("[1] Monthly");
        System.out.println("[2] Quarterly");
        System.out.println("[3] Half-yearly");
        System.out.println("[4] Yearly");
        System.out.println();
        System.out.println("Example: 1 for Monthly");

        int deductionRecieved;
        boolean isValidDeductionRecieved = false;
        do {
            deductionRecieved = sc.nextInt();
            while (deductionRecieved < 0 || deductionRecieved > 4) {
                System.out.println("Please enter a valid input");
                deductionRecieved = sc.nextInt();
            }
            deductionRecieved = ReportUtility.choiceToTrueValueIncrementConverter(deductionRecieved);
            isValidDeductionRecieved = true;
        } while(!isValidDeductionRecieved);

        // period
        System.out.print("Please enter the period of time");
        System.out.println();
        System.out.println("[1] 5 years");
        System.out.println("[2] 10 years");
        System.out.println("[3] 20 years");
        System.out.println("[4] 30 years");
        System.out.println();
        System.out.println("Example: 5 for years");

        int period;
        boolean isValidPeriod = false;
        do {

            period = sc.nextInt();
            if (period < 0 || period > 4) {
                System.out.println("Please enter a valid input");
                sc.next();
            }
            period = ReportUtility.choiceToTrueValuePeriodConverter(period);
            isValidPeriod = true;
        } while(!isValidDeductionRecieved);
        sc.close();

        System.out.println();
        System.out.println();
        System.out.println();
        ReportGenerator.generate(salary, period, interest, incrementRecieved, interestInprecentDeductions, deductionRecieved);

    }

    private static void renderBannerPage() {
        System.out.println("+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+ +-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+");
        System.out.format("%84s","|S|a|l|a|r|y| |I|n|c|o|m|e| |P|r|e|d|i|c|t|o|r|");
        System.out.println();
        System.out.println("+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+ +-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+");
        System.out.println();
        System.out.format("%84s","Submitted By: Charles Amper");
        System.out.println();
        System.out.format("%84s","Assignment 4: IIHTIBM");
        System.out.println();
        System.out.format("%84s","amperca@ph.ibm.com");
        System.out.println();
        System.out.println("WARNING:");
        System.out.println("The current program does not check strings as input. \nPlease do not attempt under any circumstances. "
                + "\nCaveat!");
        System.out.format("%70s","___________________________");
        System.out.println();
        System.out.format("%70s","<Don't even think about it >");
        System.out.println();
        System.out.format("%70s"," --------------------------");
        System.out.println();
        System.out.format("%68s","\\   ^__^");
        System.out.println();
        System.out.format("%76s","\\  (oo)\\_______");
        System.out.println();
        System.out.format("%80s","(__)\\       )\\/\\");
        System.out.println();
        System.out.format("%76s","||----w |");
        System.out.println();
        System.out.format("%76s","||     ||");
        System.out.println();
        System.out.println("+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+ +-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+");
        System.out.println();
    }

    public static void main(String[] args) {
        SalaryIncomePredictor sIp = new SalaryIncomePredictor();
        sIp.generateReport();
    }
}
