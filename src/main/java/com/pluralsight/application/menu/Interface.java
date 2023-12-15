package com.pluralsight.application.menu;

import com.pluralsight.application.table.DataManager;
import com.pluralsight.application.model.Shipper;

import java.util.List;
import java.util.Scanner;

public class Interface {

    public void displayFormat(List<Shipper> shippers) {
        System.out.println("\n\t\t\t\t\t\t[-----Shipper Data----]\n");
        System.out.printf("| %-5s | %-30s | %-30s |%n", "ID", "Company Name", "Phone Number");
        System.out.println("------------------------------------------------------------------------------");

        for (Shipper shipper : shippers) {
            System.out.printf("| %-5d | %-30s | %-30s |%n", shipper.getId(), shipper.getName(), shipper.getPhone());
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\nRedirecting...");
    }

    public void option1(DataManager table) {
        List<Shipper> ship = table.AllShippers();
        displayFormat(ship);
    }

    public void option2(DataManager table, Scanner scan) {
        scan.nextLine();
        System.out.println("Enter Company Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Company Phone Number: ");
        String phone = scan.nextLine();

        table.shipperInsert(name, phone);
    }

    public void option3(DataManager table, Scanner scan) {
        System.out.println("Choose a Shipper (ID) To Proceed: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter New Phone Number: ");
        String newPhone = scan.nextLine();

        table.updatePhoneNumber(id, newPhone);
    }

    public void option4(DataManager table, Scanner scan) {
        System.out.println("Enter Shipper (ID) To Delete: ");
        int id = scan.nextInt();

        table.shipperDelete(id);
    }
}
