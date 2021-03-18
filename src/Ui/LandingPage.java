package Ui;

import java.sql.SQLException;
import java.util.Scanner;

public class LandingPage {
    public LandingPage() throws SQLException {
        printHeader();
        printMenu();
        int choice=getMenuChoice();
        performAction(choice);
    }
    public void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Welcome to AINRA           |");
        System.out.println("|          Social Media             |");
        System.out.println("+-----------------------------------+");
    }

    public void printMenu() {

        System.out.println("1) Login ");
        System.out.println("2) Register");
        System.out.println("0) Exit");
    }
    public int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = keyboard.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 4);

        return choice;
    }
    public void performAction(int choice) throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;

            case 1:
                new LoginPage();
                break;

            case 2:
                new RegisterPage();
                break;

            default:
                System.out.println("Unknown error has occured.");


        }

    }
}
