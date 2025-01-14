package ie.hotelbooking;

public class Database {
    private final String databaseURL = "jdbc:mysql://localhost:3306/hotel_booking_system";
    private final String databaseUser = "root";
    private final String databasePassword = "#UiCM5I84evek@";

    public Database() {

    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }
}
