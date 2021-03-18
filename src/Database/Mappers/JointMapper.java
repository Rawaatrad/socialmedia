package Database.Mappers;

import Database.Database;
import Entity.Joint;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JointMapper {
    Database database;
    public JointMapper(){
    }
    public Joint createObj(ResultSet rs) throws SQLException {
        Joint joint=new Joint();
        rs.next();
        joint.setId(rs.getInt(1));
        joint.setIdGroup(rs.getInt(2));
        joint.setIdUser(rs.getInt(3));
        //joint.setStateRejoin(rs.getObject(4));
        return joint;
    }
    public int returnIdGroup (String name){
        try {
            String query = "select id from Groupe where name='" + name + "'";
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
        try {
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

    public Joint findJointById (int idMember,int idGroup){
        try
        {
            String query="select id,idGroupe,idMember,StateRjoin from Page where idMember='"+idMember+"'and idGroupe='"+idGroup+"'";
            Database database=new Database();
            ResultSet rs=database.selectExec(query);
            return createObj(rs);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void create(Joint joint) {
        String query= "INSERT INTO Page (id,idGroupe,idMember,StateRejoin) Values ('"+joint.getId()+"','"+joint.getIdGroup()
                +"','"+joint.getIdUser()+"','"+joint.getStateRejoin()+"')";
        Database database=new Database();
        database.updateExec(query);
    }
}
