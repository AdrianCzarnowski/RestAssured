package config;


import model.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.YamlReader;

import java.util.List;
import java.util.Map;

public class App {
    private static Logger log = LoggerFactory.getLogger("AppProperties.class");
    YamlReader yamlReader = new YamlReader();

    public App() {
        setEnvironmentFromYaml();
    }

    private void setEnvironmentFromYaml() {
        List<EnvironmentModel> environments = yamlReader.getConfig().getEnvironment().getEnvironments();
        boolean foundActiveBrowser = false;
        for (EnvironmentModel environmentModel : environments) {
            if (environmentModel.isActive()) {
                foundActiveBrowser = true;
                Map<String, Object> properties = environmentModel.getEnvironmentProperties();
                for (Map.Entry entry : properties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                }
                log.info("Properties size: " + properties.size());
                break;
            }
        }
    }
}