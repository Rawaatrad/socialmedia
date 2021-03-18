package Entity;

import java.util.Date;

public class SocialEntity {
    private String name ;
    private String  type;
    private Date creationDate ;
    private int idCreator;
    private int[] listModerator= new  int[] {-1,-1,-1,-1,-1};
    //constructor
    public SocialEntity(String type, int idManager,String name) {
        this.type = type;
        this.idCreator = idManager;
        this.creationDate = new Date();
        this.name= name;
    }

    public String getType() {

        return type;
    }

    public Date getCreationDate() {

        return creationDate;
    }

    public int[] getModerator() {
        return listModerator;
    }

    public int getIdCreator() {
        return idCreator;
    }
    public void addModerator(int idMember){
        int i=0;
        boolean loop = true;
        while(loop && i<5){
            if(this.listModerator[i]==-1){
                listModerator[i]=idMember;
                loop=false;
            }
            else{i++;}
        }
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreationDate (Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    public void setListModerator(int[] listModerator) {
        this.listModerator = listModerator;
    }
}
