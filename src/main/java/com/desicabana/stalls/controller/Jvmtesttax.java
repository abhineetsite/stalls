package com.desicabana.stalls.controller;

import java.util.Scanner;

public class Jvmtesttax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your taxable income: ");
        double taxableIncome = scan.nextDouble();

        System.out.println(
                "Enter your filing status (1 for single, 2 for married filing jointly, 3 for married filing separately): ");
        int filingStatus = scan.nextInt();

        double tax = 0;

        // calculate tax based on filing status
        if (filingStatus == 1) {
            // If taxable income is less than or equal to 9525, the tax rate is 10%
            tax = taxableIncome <= 9525 ? taxableIncome * 0.1 :
            // If taxable income is less than or equal to 38700, the tax rate is 10% for the
            // first 9525 and 12% for the rest
                    taxableIncome <= 38700 ? 9525 * 0.1 + (taxableIncome - 9525) * 0.12 :
                    // If taxable income is less than or equal to 82500, the tax rate is 10% for the
                    // first 9525, 12% for the next (38700 - 9525), and 22% for the rest
                            taxableIncome <= 82500 ? 9525 * 0.1 + (38700 - 9525) * 0.12 + (taxableIncome - 38700) * 0.22
                                    :
                                    // If taxable income is greater than 82500, the tax rate is 10% for the first
                                    // 9525, 12% for the next (38700 - 9525), 22% for the next (82500 - 38700), and
                                    // 24% for the rest
                                    9525 * 0.1 + (38700 - 9525) * 0.12 + (82500 - 38700) * 0.22
                                            + (taxableIncome - 82500) * 0.24;
        } else if (filingStatus == 2) {
            // If taxable income is less than or equal to 19050, the tax rate is 10%
            tax = taxableIncome <= 19050 ? taxableIncome * 0.1 :
            // If taxable income is less than or equal to 77400, the tax rate is 10% for the
            // first 19050 and 12% for the rest
                    taxableIncome <= 77400 ? 19050 * 0.1 + (taxableIncome - 19050) * 0.12 :
                    // If taxable income is less than or equal to 165000, the tax rate is 10% for
                    // the first 19050, 12% for the next (77400 - 19050), and 22% for the rest
                            taxableIncome <= 165000
                                    ? 19050 * 0.1 + (77400 - 19050) * 0.12 + (taxableIncome - 77400) * 0.22
                                    :
                                    // If taxable income is greater than 165000, the tax rate is 10% for the first
                                    // 19050, 12% for the next (77400 - 19050), 22% for the next (165000 - 77400),
                                    // and 24% for the rest
                                    19050 * 0.1 + (77400 - 19050) * 0.12 + (165000 - 77400) * 0.22
                                            + (taxableIncome - 165000) * 0.24;
        } else if (filingStatus == 3) {
            // If taxable income is less than or equal to 9525, the tax rate is 10%
            tax = taxableIncome <= 9525 ? taxableIncome * 0.1 :
            // If taxable income is less than or equal to 38700, the tax rate is 10% for the
            // first 9525 and 12% for the rest
                    taxableIncome <= 38700 ? 9525 * 0.1 + (taxableIncome - 9525) * 0.12 :
                    // If taxable income is greater than 38700, the tax rate is 10% for the first
                    // 9525, 12% for the next (38700 - 9525), and 22% for the rest
                            9525 * 0.1 + (38700 - 9525) * 0.12 + (taxableIncome - 38700) * 0.22;
        } else {
            System.out.println("Invalid filing status");
        }

        System.out.println("Your tax is: $" + tax);
        scan.close();
    }
}
