package fr.evogames.evowatchercontroller.config;

import com.google.gson.Gson;
import fr.evogames.evowatchercontroller.EvoWatcherController;
import fr.evogames.evowatchercontroller.utils.FileUtils;

import java.io.File;

public class EvoWatcherConfigDataLoader {

    private File configFile;
    private Gson gson;

    public EvoWatcherConfigDataLoader(Gson gson) {
        this.gson = gson;
        this.configFile = new File("./config.json");
    }

    public EvoWatcherConfig provideConf() {
        EvoWatcherConfig config;
        String json = FileUtils.load(this.configFile);

        if (!json.equals("")) {
            config = this.gson.fromJson(json, EvoWatcherConfig.class);
        } else {
            config = new EvoWatcherConfig();
            FileUtils.save(this.configFile, this.gson.toJson(config));
            EvoWatcherController.LOGGER.warn("New Config file, please fill it !");
            System.exit(0);
        }
        return config;
    }
}
