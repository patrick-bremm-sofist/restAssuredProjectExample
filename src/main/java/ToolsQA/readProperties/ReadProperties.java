package ToolsQA.readProperties;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties implements IReadProperties {
    private String fileName;

    ReadProperties(String fileName) {
        this.fileName = fileName;
    }
    
    public String get(String key) throws Exception {
        String configPath = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(configPath));
            return appProps.getProperty(key);
        } catch (Exception e) {
            throw new Exception("Error read properties");
        }
    }
}
