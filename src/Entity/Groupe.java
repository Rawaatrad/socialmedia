package Entity;

public class Groupe extends SocialEntity {
        private int id ;

        public void setId(int id) { this.id = id; }

        public Groupe(String type, int idManager, String name) {
            super(type, idManager,name);

        }

        public int getId() { return id; }
}
