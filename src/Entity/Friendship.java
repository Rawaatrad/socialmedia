package Entity;

enum StateShip {
    sent , accepted
}

public class Friendship {
    private int id ;
    private int idTransmitter;
    private int idReceiver;
    public StateShip FriendshipState;


    public Friendship(int id,int idTransmitter, int idReceiver) {
        this.id=id;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.FriendshipState = StateShip.sent;
    }

    public static void setCounter(int counter) {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdTransmitter(int idTransmitter) {
        this.idTransmitter = idTransmitter;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public void setFriendshipState(StateShip friendshipState) {
        FriendshipState = friendshipState;
    }

    public int getId() {
        return id;
    }

    public int getIdTransmitter() {
        return idTransmitter;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public StateShip getFriendshipState() {
        return FriendshipState;
    }

    public void accept () {

        this.FriendshipState =StateShip.accepted;

    }

    public void refuse () {
        // delete a line from Friendship table .
    }


}
