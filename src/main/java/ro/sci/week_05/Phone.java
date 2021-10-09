package ro.sci.week_05;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phone {
    private String imeiCode;
    private Color color;
    private String material;
    private List<Contact> contactsList = new ArrayList<>();
    String message;

    public Phone(String imeiCode, Color color, String material) {
        this.imeiCode = imeiCode;
        this.color = color;
        this.material = material;
    }

    public void addContact(Contact contact) {
        contactsList.add(contact);
    }

    public void listContacts() {
        System.out.println("Your contact list has " + contactsList.size() + " contacts");
        System.out.println(contactsList);
        }


    public boolean sendMessage(Contact contact, String message_content) {
        if (message_content.length()<= 100){
            this.message=message_content;
        return true;
        }
        return false;
    }

    public void listMessages(String message) {
        System.out.println(" This Message: ' " +message +" ' was sent to " +contactsList.get(0));
    }

    public boolean call(Contact contact) {
      return true;
    }
    public void viewHistory() {
        System.out.println("You called " + contactsList.get(1));
    }

    @Override
    public String toString() {
        return "Phone{" +
                "imeiCode='" + imeiCode + '\'' +
                ", color=" + color +
                ", material='" + material + '\'' +
                ", contactsList=" + contactsList +
                '}';
    }
}