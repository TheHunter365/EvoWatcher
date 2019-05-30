package fr.evogames.evowatchercontroller.config;

public class TimeSeriesDBCredentials {

    private String host;
    private String user;
    private String pass;

    private String database;

    public TimeSeriesDBCredentials(String host, String user, String pass, String database) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDatabase() {
        return database;
    }
}
