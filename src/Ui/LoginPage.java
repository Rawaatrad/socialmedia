package Ui;

import Database.Mappers.MemberMapper;
import Entity.Member;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginPage {
    public String email;
    public String password;
    public LoginPage() throws SQLException {
        performAction(getEmail(),getPassword());


    }
    public String getEmail(){
        System.out.println("give your email: ");
        Scanner keyboard = new Scanner(System.in);
        email = keyboard.nextLine();
        return email;
    }
    public String getPassword(){
        System.out.println("give your password: ");
        Scanner keyboard = new Scanner(System.in);
        password = keyboard.nextLine();
        return password;
    }
    public void performAction(String mail, String pwd) throws SQLException {
        MemberMapper mapper = new MemberMapper();
        Member membre = mapper.findByCredentials(mail, pwd);
        if (membre != null) {

            System.out.println("Connected.");
            new HomePage(membre);
        } else {
            System.out.println("you don't have an account");

        }

    }

}
