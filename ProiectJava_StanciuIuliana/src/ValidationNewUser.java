public class ValidationNewUser {
    NewConnection connection;
    ValidationNewUser(String con) {
        connection = new NewConnection();
        if (con.equalsIgnoreCase("new"))
            connection.setNewConnection();
        connection.log();
    }
}
