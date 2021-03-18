package Entity;


public class Member {
    private int id ;
    private String nameUser;
    private String password;
    private String email;

    public Member() {
    }
    public Member( String nameUserIn, String passwordIn, String addressIn){

        nameUser = nameUserIn;
        password = passwordIn;
        email = addressIn;
    }


    public Member(int id, String nameUserIn, String passwordIn, String addressIn){
        id=id;
        nameUser = nameUserIn;
        password = passwordIn;
        email = addressIn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }
    public String getNameUser() {
        return nameUser;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() { return email;}

    public void addSocialManager(int idSocial, int idMember) {
        //if member === manager -> add member
    }
    public void deleteSocialManager(int idSocial,int idMember){

    }








}
