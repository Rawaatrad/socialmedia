package Entity;

public class Page extends SocialEntity {
    private int id ;

    public Page(String type, int idManager,String name) {
        super(type, idManager, name);

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
