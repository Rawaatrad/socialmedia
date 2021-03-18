package Ui;

import Database.Mappers.MemberMapper;
import Entity.Member;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisterPage {
    public RegisterPage() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("choose a username: ");
        String username = keyboard.nextLine();
        System.out.println("Email: ");
        String email= keyboard.nextLine();
        System.out.println("password: ");
        String password = keyboard.nextLine();
        Member member = new Member(username,email,password);
        MemberMapper mapper=new MemberMapper();
        mapper.create(member);
        HomePage home= new HomePage(member);




    }
}
