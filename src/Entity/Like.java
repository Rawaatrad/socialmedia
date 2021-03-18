package Entity;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Like {
    private int counter = 0;
    private int id ;
    private int idMember  ;
    private int idPage  ;

    public Like() {
    }

    public Like(int idMember, int idPage) {
        this.id = counter++;
        this.idMember = idMember;
        this.idPage = idPage;
    }

    public int getId() { return id; }

    public int getIdMember() { return idMember; }

    public int getIdPage() { return idPage; }

    public void setId(int id) { this.id = id; }

    public void setIdMember(int idMember) { this.idMember = idMember; }

    public void setIdPage(int idPage) { this.idPage = idPage; }


    public List<Integer> listMemberPage(int idPage ) throws SQLException {
        ArrayList<Integer> listMember =new ArrayList<Integer>() ;
        String query ="select idMember from liker where idPage= '"+idPage+"'";
        Database database = new Database();
        ResultSet rs = database.selectExec(query);
        while (rs.next())
        {
            listMember.add(rs.getInt(1));
        }
        return listMember;
    }

    public List<Integer> listLikerPage(int idMember ) throws SQLException {
        ArrayList<Integer> listPage =new ArrayList<Integer>() ;
        String query ="select idPage from Liker where idMember= '"+idMember+"'";
        Database database = new Database();
        ResultSet rs = database.selectExec(query);
        while (rs.next())
        {
            listPage.add(rs.getInt(1));
        }
        return listPage;
    }
}
