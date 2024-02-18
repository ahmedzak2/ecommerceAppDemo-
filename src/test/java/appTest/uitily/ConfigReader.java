package appTest.uitily;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static final Map<String, ConfigReader> instances = new HashMap<>();

    // Private constructor to prevent direct instantiation
    public ConfigReader(String propertiesFilePath) {
        properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFilePath)) {
            properties.load(input);
        } catch (IOException ex) {
            // Consider more robust error handling or fallback logic here
            ex.printStackTrace();
        }
    }

    // Public method to get an instance of ConfigReader
    public static synchronized ConfigReader getInstance(String propertiesFilePath) {
        // Use the properties file path as the key to store/retrieve instances
        if (!instances.containsKey(propertiesFilePath)) {
            instances.put(propertiesFilePath, new ConfigReader(propertiesFilePath));
        }
        return instances.get(propertiesFilePath);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String encodeFileToBase64Binary(File file) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
