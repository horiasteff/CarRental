package ro.jademy.carrental.data;

import java.util.Scanner;

public class Features {
    Scanner sc = new Scanner(System.in);
    String output;


    protected long deliverHome() {
        String answer;
        long km = 0;
        System.out.println("Do you want to deliver the car to your home?");
        output = sc.next();
        if (output.equalsIgnoreCase("yes")) {
            System.out.println("Is Bucharest your city?");
            answer = sc.next();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("There are no other taxes");
            } else {
                System.out.println("There is a tax of $25/100km out of Bucharest");
                System.out.println("How many km are from Bucharest to your city?");
                km = sc.nextInt();

            }
        }
        return (long) (km * 0.25);
    }

    protected void payInRates(long price) {
        int rate;
        System.out.println("Do you want to pay in rates?");
        output = sc.next();
        if (output.equalsIgnoreCase("yes")) {
            System.out.println("How many rates do you want?");
            System.out.println("You can choose between 3/6/9/12");
            rate = sc.nextInt();
            System.out.println("The price per month is: $" + price/rate);
        }
    }
}
