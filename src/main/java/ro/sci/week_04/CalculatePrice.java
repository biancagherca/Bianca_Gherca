package ro.sci.week_04;

import java.util.Scanner;

public class CalculatePrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the base price");
        double basePrice = scanner.nextDouble();

        System.out.println("Please enter the VAT(%)");
        int vat = scanner.nextInt();

        System.out.println("The final price is " + calculatePrice(basePrice, vat));
    }

    public static double calculatePrice(double basePrice, int vat) {
        double finalPrice;
        finalPrice = basePrice + basePrice * vat / 100;
        return finalPrice;
    }
}
