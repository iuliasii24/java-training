public class Singleton {
    private static Singleton obj;
    private Singleton() {}
    public static Singleton getInstance() {
        // create object if it's not already created
        if(obj == null) {
            obj = new Singleton();
        }
        // returns the singleton object
        return obj;
    }
    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }
}
