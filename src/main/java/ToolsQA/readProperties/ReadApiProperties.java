package ToolsQA.readProperties;

public class ReadApiProperties implements IReadProperties {
    @Override
    public String get(String key) throws Exception {
        return new ReadProperties("api.properties").get(key);
    }
}
