package appTest.uitily;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public ConfigReader() {
        try (InputStream input = new FileInputStream("src/test/resources/configure.properties")) {
            // rest of your code
            properties = new Properties();
            // Load a properties file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String encodeFileToBase64Binary(File file) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
