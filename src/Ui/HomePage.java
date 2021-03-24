package Ui;

import Algorithm.Research;
import Entity.Member;

import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {
    private Member member;
    public HomePage(Member member) throws SQLException {
        this.member=member;
        System.out.println("Welcome to AINRA " + member.getNameUser());
        printMenu();
        int choice =getMenuChoice();
        performAction(choice);


    }

    public void printMenu() {
        System.out.println("1) Search a friend,a group or a page");
        System.out.println("2) Create a groupe or a page");
        System.out.println("3) voir les demandes d'amitié");
        System.out.println("4) see your friends");

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
                String name = keyboard.nextLine();
                Research research =new Research();
                Member mem=research.ResearchMember(member,name);
                System.out.println(mem.getNameUser());

                break;

            case 2:
                new RegisterPage();
                break;
            case 3:
                new FriendSList(member);
                break;


            default:
                System.out.println("Unknown error has occured.");
                break;


        }
    }
}
