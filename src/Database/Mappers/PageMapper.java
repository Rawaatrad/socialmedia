package Database.Mappers;

import Database.Database;
import Entity.Page;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PageMapper {
    Database database;
    public PageMapper() {
    }
    public Page createObj(ResultSet rs) throws SQLException{
        Page page = new Page(rs.getString(5),rs.getInt(3),rs.getString(4));
        rs.next();
        page.setId(rs.getInt(1));
        page.setCreationDate(rs.getDate(2));
        return page;
    }
    public int returnId (String name){
        try
        {
            String query = "select id from Page where name='"+ name+"'";
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
    public Page findPageById (int id){
        try
        {
            String query="select id,creationDate,idManager,name,type from Page where id='"+id+"'";
            Database database=new Database();
            ResultSet rs=database.selectExec(query);
            return createObj(rs);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public void create(Page page) {
        String query= "INSERT INTO Page (id,creationDate,idManager,name,type) Values ('"+page.getId()+"','"+page.getCreationDate()
                +"','"+page.getIdCreator()+"','"+page.getName()+"','"+page.getType()+"')";
        Database database=new Database();
        database.updateExec(query);
    }
}
