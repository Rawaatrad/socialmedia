package Database.Mappers;

import Database.Database;
import Entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

// Classe représentant le mapper d'un utilisateur.

public class MemberMapper {


    // Create a member in the database

    public void create(Member member) {
        String query = "INSERT INTO Member (username,email,password) Values ('" + member.getNameUser() + "','" + member.getEmail()
                + "','" + member.getPassword() + "')";
        Database database = new Database();
        database.driver();
        database.OpenConnexion();
        database.updateExec(query);


    }

    //create a member with rs
    public Member create(ResultSet rs) throws SQLException {
        Member membre = new Member();
        rs.next();
        membre.setId(rs.getInt(1));
        membre.setPassword(rs.getString(2));
        membre.setNameUser(rs.getString(4));
        membre.setEmail(rs.getString(3));
        return membre;

    }

    // Return a member by email and password
    public Member findByCredentials(String email, String password) throws SQLException {
        try {
            String query = "select id,password,email,userName from Member where email='" + email + "'";
            Database database = new Database();
            database.driver();
            database.OpenConnexion();
            ResultSet rs = database.selectExec(query);

            return create(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //return a member by id
    public Member findById(int id) {
        try {
            String query = "select id,password,email,userName from Member where id=" + id;
            Database database = new Database();
            database.driver();
            database.OpenConnexion();
            ResultSet rs = database.selectExec(query);

            return create(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
    //nombre d'utilisateurs
    public int nbreUtilisateurs() throws SQLException {
        String query ="Select id  FROM Member";
        Database database = new Database();
        database.driver();
        database.OpenConnexion();
        ResultSet rs = database.selectExec(query);
        int nombre=0;
        while (rs.next()){
            nombre +=1;
        }
        return nombre;

    }

}



