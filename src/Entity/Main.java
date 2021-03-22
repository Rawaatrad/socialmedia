package Entity;

import Database.Mappers.FriendshipMapper;
import Database.Mappers.MemberMapper;
import Ui.LandingPage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));*/
        FriendshipMapper fr =new FriendshipMapper();
        MemberMapper map = new MemberMapper();
        ArrayList<Member> m = fr.findFriends(map.findById(3));

        for (Member member :m){
            System.out.println(member.getNameUser());
        }
        //new LandingPage();
        System.out.println(map.nbreUtilisateurs());





    }

}

