package Ui;

import Database.Mappers.FriendshipMapper;
import Database.Mappers.MemberMapper;
import Entity.Friendship;
import Entity.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendSList {
    private Member member;

    public FriendSList(Member member) {
        this.member = member;
        dealWithRequests();
    }
    public void dealWithRequests(){
        FriendshipMapper mapper =new FriendshipMapper();
        MemberMapper mapper1 = new MemberMapper();
        ArrayList<Friendship> requests=mapper.friendshipRequests(member);

        for (Friendship friendship :requests){
            String sender= mapper1.findById(friendship.getIdTransmitter()).getNameUser();
            System.out.println(sender+"  sent to you a request , do you want to accept it ? ");
            printChoices();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    mapper.acceptFriendship(friendship);
                    break;

                case 2:
                    mapper.refuseFriendship(friendship);
                    break;
                case 3:

                    break;}



        }
    }
    public int getChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = keyboard.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 1 || choice > 3);

        return choice;
    }
    public void printChoices() {
        System.out.println("1) yes");
        System.out.println("2) no");
        System.out.println("3) later");

    }


}

