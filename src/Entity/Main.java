package Entity;

import Algorithm.Research;
import Database.Mappers.FriendshipMapper;
import Database.Mappers.MemberMapper;
import Ui.LandingPage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        MemberMapper mapper=new MemberMapper();
        System.out.println(mapper.biggestId());


    }

}

