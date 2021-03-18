package Entity;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Joint {
    enum State {
        sent, accepted
    }

        private static int count =0;
        private int id;
        private int idGroup;
        private int idUser;
        private State stateRejoin;

        public Joint() {
        }

        public Joint (int idGroupIn, int idUserIn) {
            id = count++;
            idGroup = idGroupIn;
            idUser = idUserIn;
            stateRejoin = State.sent;
        }

        public void setId(int id) { this.id = id; }

        public void setIdGroup(int idGroup) { this.idGroup = idGroup; }

        public void setIdUser(int idUser) { this.idUser = idUser; }

        public void setStateRejoin(State stateRejoin) { this.stateRejoin = stateRejoin; }

        public int getId() { return id;}
        public int getIdGroup() { return idGroup; }
        public int getIdUser() { return idUser; }
        public State getStateRejoin() { return stateRejoin; }

        public void accept () {
            stateRejoin = State.accepted;
        }
        public void refuse(){
            //destructor
            //delete from database;
        }
        public List<Integer> listMemberGroup(int idGroup ) throws SQLException {
            ArrayList<Integer> listMember =new ArrayList<Integer>() ;
            String query ="select idMember from joint where idGroupe= '"+idGroup+"'";
            Database database = new Database();
            ResultSet rs = database.selectExec(query);
            while (rs.next())
            {
                listMember.add(rs.getInt(1));
            }
            return listMember;
        }
        public List<Integer> listJointGroup(int idMember ) throws SQLException {
            ArrayList<Integer> listGroupe =new ArrayList<Integer>() ;
            String query ="select idGroupe from Joint where idMember= '"+idMember+"'";
            Database database = new Database();
            ResultSet rs = database.selectExec(query);
            while (rs.next())
            {
                listGroupe.add(rs.getInt(1));
            }
            return listGroupe;
        }
}
