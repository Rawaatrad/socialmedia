package Entity;

public class Message {
    private int id;
    private  static int counter = 0  ;
    private int idAuthor;
    private int idReceiver;
    private String text;

    public Message(int idAuthor, int idReceiver, String text) {
        this.id = counter++;
        this.idAuthor = idAuthor;
        this.idReceiver = idReceiver;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public String getText() {
        return text;
    }




}
