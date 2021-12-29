package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigProvider {

    private static Config config;
    private static Config properties;

    public static Config config(){
        if(ConfigProvider.config == null){
            ConfigProvider.config = ConfigFactory.load();
            ConfigProvider.properties = ConfigFactory.load().getConfig("api");
        }
        return ConfigProvider.properties.withFallback(ConfigProvider.config);
    }
}
