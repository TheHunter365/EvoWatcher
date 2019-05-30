package fr.evogames.evowatchercontroller.config;

public class EvoWatcherConfig {

    private TimeSeriesDBCredentials timeSeriesDBCredentials;

    public EvoWatcherConfig() {
        this.timeSeriesDBCredentials = new TimeSeriesDBCredentials("toFill", "toFill", "toFill", "toFill");
    }

    public TimeSeriesDBCredentials getTimeSeriesDBCredentials() {
        return timeSeriesDBCredentials;
    }

}
