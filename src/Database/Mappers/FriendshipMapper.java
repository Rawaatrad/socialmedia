package Database.Mappers;

import Database.Database;

import Entity.Friendship;
import Entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FriendshipMapper {

    public ArrayList<Member> findFriends(Member member) throws SQLException {
        MemberMapper mapper =new MemberMapper();
        ArrayList<Member> list=new ArrayList<Member>();
        String query = "select * from FriendShip where (idReceiver="+member.getId()+" or idTransmitter="+member.getId()+") and StateShip='accepted'" ;

        Database database = new Database();
        database.driver();
        database.OpenConnexion();
        ResultSet rs = database.selectExec(query);
        while (rs.next()) {

                if(member.getId() == rs.getInt(2)){
                  list.add(mapper.findById(rs.getInt(3)));
                }
                else if (member.getId() == rs.getInt(3)){
                    list.add(mapper.findById(rs.getInt(2)));
                }

                }

            return list;



    }


    //transmitter send a request to a reciever :tested
    public void sendRequest(Member transmitter,Member reciever) {
        //test
        String query="INSERT INTO FriendShip (idTransmitter,idReceiver,StateShip) Values ("
                +transmitter.getId()+","+reciever.getId()+",'sent')";
        Database database=new Database();
        database.driver();
        database.OpenConnexion();
        database.updateExec(query);


    }
    //a partir d'un rs donner une liste des friendship
    public ArrayList<Friendship> create(ResultSet rs) throws SQLException {
        ArrayList<Friendship> list = new ArrayList<Friendship>();
        while (rs.next()) {
            list.add(new Friendship(rs.getInt(1),
                    rs.getInt(2), rs.getInt(3)));}
        return list;

    }
   //invitations sent to a member : a partir d'un membre
    public ArrayList<Friendship> friendshipRequests(Member member) {

        try {
            String query = "select * from FriendShip where idReceiver="+member.getId()+" and StateShip='sent'" ;
            Database database = new Database();
            database.driver();
            database.OpenConnexion();
            ResultSet rs = database.selectExec(query);
            return create(rs);
        }
        catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }

   //tested
    public void acceptFriendship(Friendship f){
        try {
            String query = "UPDATE FriendShip SET StateShip = 'accepted' WHERE id="+f.getId();
            Database database = new Database();
            database.driver();
            database.OpenConnexion();
            int rs = database.updateExec(query);

        }
        catch (Exception e) {
            System.out.println(e);

        }



    }
    public void refuseFriendship(Friendship f){
        try {
            String query = "delete from FriendShip  WHERE id="+f.getId();
            Database database = new Database();
            database.driver();
            database.OpenConnexion();
            int rs = database.updateExec(query);

        }
        catch (Exception e) {
            System.out.println(e);

        }


    }
    public ArrayList<Friendship> friends(Member member) {

        try {
            String query = "select * from FriendShip where idReceiver="+member.getId()+ "and StateShip='sent'" ;
            Database database = new Database();
            database.driver();
            database.OpenConnexion();
            ResultSet rs = database.selectExec(query);
            return create(rs);
        }
        catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }

}

