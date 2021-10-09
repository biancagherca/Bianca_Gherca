package ro.sci.week_05;

import ro.sci.week_05.PhoneManufacturers.Samsung;

import ro.sci.week_05.PhoneModels.Iphone12;
import ro.sci.week_05.PhoneModels.SamsungGalaxyS20;

import java.awt.*;
import java.util.Scanner;

public class MainWeek05 {
    public static void main(String[] args) {
        Phone samsungPhone = new SamsungGalaxyS20("3519 2410 0188 669", Color.WHITE, "glass and aluminium");
        Phone applePhone = new Iphone12("01 242300 447489 6", Color.BLACK, "glass and aluminium");

        Contact contact1 = new Contact("0729845638", "Elena", "Barat");
        Contact contact2 = new Contact("0729565856", "Mircea", "G");


        applePhone.addContact(contact1);
        applePhone.addContact(contact2);
        applePhone.listContacts();


        // send a message to the first contact from the previous listed
        System.out.println("Please enter a message");
        Scanner scanner = new Scanner(System.in);
        String message_content = scanner.next();


        applePhone.sendMessage(contact1, message_content);
        applePhone.listMessages(message_content);

        // make a call to the second contact from the previous listed
        applePhone.call(contact2);
        applePhone.viewHistory();




    }

}
