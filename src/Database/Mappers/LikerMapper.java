package Database.Mappers;

import Database.Database;
import Entity.Like;


import java.sql.ResultSet;
import java.sql.SQLException;

public class LikerMapper {
    Database database;
    public LikerMapper(){
    }
    public Like createObj(ResultSet rs) throws SQLException {
        Like like=new Like();
        rs.next();
        like.setId(rs.getInt(1));
        like.setIdPage(rs.getInt(2));
        like.setIdMember(rs.getInt(3));
        //like.setStateRejoin(rs.getObject(4));
        return like;
    }
    public int returnIdPage (String name){
        try {
            String query = "select id from Page where name='" + name + "'";
            Database database = new Database();
            ResultSet rs = database.selectExec(query);
            return rs.getInt(1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return -1;
    }
    public int returnIdMember (String name){
        try
        {
            String query = "select id from Member where nameUser='" + name + "'";
            Database database = new Database();
            ResultSet rs = database.selectExec(query);
            return rs.getInt(1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public Like findLikertById (int idMember,int idPage){
        try
        {
            String query="select id,idMember,idPage from Page where idMember='"+idMember+"'and idPage='"+idPage+"'";
            Database database=new Database();
            ResultSet rs=database.selectExec(query);
            return createObj(rs);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void create(Like like) {
        String query= "INSERT INTO Liker (id,idMember,idPage) Values ('"+like.getId()+"','"+like.getIdPage()
                +"','"+like.getIdMember()+"')";
        Database database=new Database();
        database.updateExec(query);
    }
}
