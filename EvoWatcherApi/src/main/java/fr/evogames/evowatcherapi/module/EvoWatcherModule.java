package fr.evogames.evowatcherapi.module;

import fr.evogames.evowatcherapi.EvoWatcherApi;

public abstract class EvoWatcherModule {

    private EvoWatcherApi evoWatcherApi;
    private EvoModuleDescription description;


    public void onLoad() {

    }

    public void init(EvoWatcherApi api, EvoModuleDescription description) {
        this.evoWatcherApi = api;
        this.description = description;
    }

    public EvoWatcherApi getEvoWatcherApi() {
        return evoWatcherApi;
    }

    /*private String getModuleName() {

    }*/
}
