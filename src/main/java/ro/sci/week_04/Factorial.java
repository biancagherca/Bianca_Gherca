package ro.sci.week_04;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Please enter a number");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long factorial = factorial(number);

        System.out.println("Factorial of " + number + " is " + factorial);
    }

    public static int factorial(int number) {
        if (number == 0)
            return 1;
        else
            return (number * factorial(number - 1));

    }
}
