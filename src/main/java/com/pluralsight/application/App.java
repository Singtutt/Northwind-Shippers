package com.pluralsight.application;

import com.pluralsight.application.menu.Interface;
import com.pluralsight.application.table.DataManager;
import com.pluralsight.application.table.connect.DataConnect;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Interface menu = new Interface();
        DataManager table = new DataManager();
        Scanner scan = new Scanner(System.in);

        try {
            DataConnect.sqlConnection();
            while (true) {
                System.out.println("""
                        \n\n\t\t[~Shipper Data Handling Application~]
                        \t\t\t\t\t[-Main Menu-]
                                            
                        What would you like to do with the Shipper Data?
                                            
                        \t1. View All Shipper Details.
                        \t2. Add New Shipper Entry.
                        \t3. Update Phone Number Entry.
                        \t4. Delete Shipper Entry.
                        \t0. Exit Application.
                                            
                        Enter An Option:""");
                int option = userInput(scan);

                switch (option) {
                    case 1:
                        menu.option1(table);
                        break;
                    case 2:
                        menu.option2(table, scan);
                        break;
                    case 3:
                        menu.option3(table, scan);
                        break;
                    case 4:
                        menu.option4(table, scan);
                        break;
                    case 0:
                        System.out.println("Exiting Application... Have A Good Day!");
                        DataConnect.dataCloser();
                        System.exit(0);
                    default:
                        System.out.println("""
                                \n\t\t\t\t[~Invalid Option~]
                                                            
                                Redirecting...""");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataConnect.dataCloser();
        }
    }

    //  Error Handling: User Option Input
    private static int userInput(Scanner scan) {
        int option = -1;
        boolean valid = false;

        while (!valid) {
            try {
                option = scan.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("""
                        [~Invalid Option~]
                                                    
                        Enter A Valid Option:\s""");
                scan.nextLine();
            }
        }
        return option;
    }
}
