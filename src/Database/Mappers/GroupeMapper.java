package Database.Mappers;

import Database.Database;
import Entity.Groupe;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupeMapper {
    Database database;
    public GroupeMapper() {
    }

    public Groupe createObj(ResultSet rs) throws SQLException {
        Groupe group = new Groupe(rs.getString(5),rs.getInt(3),rs.getString(4));
        rs.next();
        group.setId(rs.getInt(1));
        group.setCreationDate(rs.getDate(2));
        return group;
    }


    public int returnId (String name){
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


    public Groupe findGroupById (int id){
        try
        {
            String query="select id,creationDate,idManager,name,type from Groupe where id='"+id+"'";
            Database database=new Database();
            ResultSet rs=database.selectExec(query);

            return createObj(rs);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public void create(Groupe group) {
        String query= "INSERT INTO Groupe (id,creationDate,idManager,name,type) Values ('"+group.getId()+"','"+group.getCreationDate()
                +"','"+group.getIdCreator()+"','"+group.getName()+"','"+group.getType()+"')";
        Database database=new Database();
        database.updateExec(query);
    }

}
