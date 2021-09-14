package ro.sci.tema03;


import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            if(name.equals(""))
                System.out.println("Hello, stranger.");
            else
                System.out.println("Hello, " +name +"!");


        }
    }


