package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chandrashekar.v on 9/4/2017.
 */
public class HowMuch2 {
    private static final double R1 = 0.01675;
    private static final double R2 = 0.0160;
    private static final int P1 = 3000000;
    private static final int P2 = 2000000;
    public static final int ONE_L = 100000;
    private static int sno = 0;


    public static void main(String[] args) {
        // For interest
        // 1. is interest added to 1 lakh? then add round figure in lakhs to principle
        // 2. after adding take remaining amount and to accumulator
        // For accumulating amount perform steps 1 & 2.
        // calculate interest for the total amount from start date end date.

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 8, 01);
        final Date currentDate = calendar.getTime();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(currentDate);
        calendar1.add(Calendar.MONTH, 120);

        final Date endDate = calendar1.getTime();

        double amount1 = P1;
        double amount2 = P2;


        System.out.println("Start Date:" + calendar.getTime());
        System.out.println("End Date:" + endDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYY");
        int count = 0;
        double interest1 = 0;
        double interest2 = 0;

        while (endDate.after(calendar.getTime())) {

            // Calculate Interest
            interest1 += (amount1 * R1);
            //interest2 += (amount2 * R2);
            count++;

            calendar.add(Calendar.MONTH, 1);
            String displayDate = dateFormat.format(calendar.getTime());
            double total = amount1 /*+ amount2*/;
            double multiplier1 = Math.floor(amount1 / ONE_L);
            //double multiplier2 = Math.floor(amount2 / ONE_L);

            System.out.printf("%d,%s,%.0f,%.0f,%.0f,%.0f,%.0f", ++sno, displayDate, interest1, interest2, amount1, amount2, total);
           System.out.println();

            if (count == 3) {
                // Add to Total
                amount1 += interest1;
               // amount2 += interest2;

                /*if (total - (multiplier * ONE_L) <= 20000) {
                    System.out.println("Give " + (total - (multiplier * ONE_L)));

                }*/
                count = 0;
                interest1 = 0;
                //interest2 = 0;
            }

        }

    }
}
