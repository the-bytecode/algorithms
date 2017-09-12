package com;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by chandrashekar.v on 9/4/2017.
 */
public class HowMuch {

    private static final int R = 1600;
    private static final int P = 3000000;
    public static final int ONE_L = 100000;


    public static void main(String[] args) {
        // For interest
        // 1. is interest added to 1 lakh? then add round figure in lakhs to principle
        // 2. after adding take remaining amount and to accumulator
        // For accumulating amount perform steps 1 & 2.
        // calculate interest for the total amount from start date end date.

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 8, 02);
        final Date currentDate = calendar.getTime();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(currentDate);
        calendar1.add(Calendar.MONTH, 60);

        final Date endDate = calendar1.getTime();

        double amount = P;
        double monthlyInterest = 0;
        double accInterest = 0;
        System.out.println("Start Date:" + calendar.getTime());
        System.out.println("End Date:" + endDate);

        System.out.printf("%s %12s %8s %8s %10s", "Date", "Amount", "Interest", "accI", " Remarks");
        System.out.println();
        while (endDate.after(calendar.getTime())) {

            int multiplier = (int) (amount / ONE_L);
            double currentMonthI = multiplier * R;
            monthlyInterest += multiplier * R;

            double displyMonthlyI = monthlyInterest + accInterest;
            double amountTillDate = amount;
            boolean give = false;
            double giveA = 0;

            int count = 0;
            if (monthlyInterest >= ONE_L) {
                amount += ONE_L;
                count++;
                double addToAcc = monthlyInterest - ONE_L;
                monthlyInterest -= ONE_L;
                monthlyInterest -= addToAcc;
                accInterest += addToAcc;
            } else if (ONE_L - monthlyInterest <= 5000) {
                if (accInterest >= (ONE_L - monthlyInterest)) {
                    accInterest -= (ONE_L - monthlyInterest);
                } else {
                    give = true;
                    giveA = (ONE_L - monthlyInterest);
                }
                monthlyInterest += (ONE_L - monthlyInterest);
                amount += ONE_L;
                count++;
                double addToAcc = monthlyInterest - ONE_L;
                monthlyInterest -= ONE_L;
                accInterest += addToAcc;
            }

            if (accInterest >= ONE_L) {
                amount += ONE_L;
                count++;
                accInterest -= ONE_L;
            }

            if (monthlyInterest + accInterest > ONE_L) {
                double remaining = monthlyInterest + accInterest - ONE_L;
                amount += ONE_L;
                count++;
                monthlyInterest = 0;
                accInterest = remaining;
            }
            calendar.add(Calendar.MONTH, 1);

            String displayDate = "01/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
            System.out.printf("%s,%.0f,%.0f,%.0f,%.0f,%.0f,Give %.0f,Add %d Lakhs to Total", displayDate, amountTillDate, displyMonthlyI, amount, currentMonthI, accInterest, giveA, count);
            System.out.println();

            giveA = 0;
            count = 0;

        }

    }
}
