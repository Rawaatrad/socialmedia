package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database implements java.io.Serializable {
    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;

    public Database() {}

    public boolean driver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du pilote :" + e.getMessage());
            return false;
        }
    }


    public boolean OpenConnexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/socialmedia";
            con = DriverManager.getConnection(url, "root", "Raw3aTrad.");
            return true;
        } catch (Exception e) {
            System.out.println("Echec de l'ouverture de la connexion :" + e.getMessage());
            return false;
        }

    }

    public boolean closeConnection() {
        try {
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Echec de la fermeture de la connexion :" + e.getMessage());
            return false;
        }
    }
    public ResultSet selectExec(String sql){
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(Exception e){
            System.out.println("Echec de l'exécution de la requête sql :"+e.getMessage());
        }
        return rs ;
    }
    public int updateExec(String sql) {
        int i = 0 ;
        try{
            con.setAutoCommit(false);
            stmt = con.createStatement() ;
            i = stmt.executeUpdate(sql) ;
            con.commit();
        }
        catch(Exception e)
        {
            System.out.println("Echec de l'exécution de la requête sql :"+e.getMessage());
        }
        return i ;
    }
    public boolean closeResultSet(){
        try{
            rs.close();
            return true ;
        }
        catch (Exception e){
            System.out.println("Echec de la fermeture de l'objet ResultSet :"+ e.getMessage());
            return false ;
        }
    }
    public boolean closeStatement() {
        try{
            stmt.close();  return true ;
        }
        catch (Exception e){
            System.out.println("Echec de la fermeture de l'objet Statement :"+ e.getMessage());   return false ;
        }
    }




}

