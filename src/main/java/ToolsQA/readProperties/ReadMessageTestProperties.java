package ToolsQA.readProperties;

public class ReadMessageTestProperties implements IReadProperties {
    @Override
    public String get(String key) throws Exception {
        return new ReadProperties("data-test.properties").get(key);
    }
}
