package fr.evogames.evowatchercontroller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.evogames.evoconnector.EvoConnector;
import fr.evogames.evowatchercontroller.config.EvoWatcherConfig;
import fr.evogames.evowatchercontroller.config.EvoWatcherConfigDataLoader;
import fr.evogames.evowatchercontroller.database.InfluxDBConnector;
import fr.evogames.evowatchercontroller.database.TimeSeriesDataBase;
import fr.evogames.evowatchercontroller.metrics.MetricsManager;

public class EvoWatcherController {

    //public static Logger LOGGER;

    private Gson gson;

    private EvoWatcherConfig config;
    private TimeSeriesDataBase timeSeriesDataBase;

    private EvoConnector connector;

    public EvoWatcherController() {

        //LOGGER = LoggerFactory.getLogger(EvoWatcherController.class);

        this.gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        this.config = new EvoWatcherConfigDataLoader(this.gson).provideConf();

        //LOGGER.info("Strating timeseriesdb Conenction");
        this.timeSeriesDataBase = new InfluxDBConnector(
                this.config.getTimeSeriesDBCredentials().getHost(),
                this.config.getTimeSeriesDBCredentials().getUser(),
                this.config.getTimeSeriesDBCredentials().getPass()
                );

        if (timeSeriesDataBase instanceof InfluxDBConnector) {
            InfluxDBConnector connector = (InfluxDBConnector) this.timeSeriesDataBase;
            connector.setDatabase(this.config.getTimeSeriesDBCredentials().getDatabase());
        }
        //LOGGER.info("Strating Messager Conenction");
        this.connector = new EvoConnector();
        this.connector.getEventManager().registerListener(new MetricsManager(this.timeSeriesDataBase));

    }

    public EvoConnector getConnector() {
        return connector;
    }

    public TimeSeriesDataBase getTimeSeriesDataBase() {
        return timeSeriesDataBase;
    }
}
