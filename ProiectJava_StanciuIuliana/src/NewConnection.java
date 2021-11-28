public class NewConnection {
    private static Operation con;
    public static NewUser user;

    NewConnection()
    {
        user= new NewUser();
    }

    public void setNewConnection() {
        con = user;
    }

    public void log() {
        con .log();
    }
}
