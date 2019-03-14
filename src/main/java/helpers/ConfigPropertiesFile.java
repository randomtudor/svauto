package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesFile implements Config {
  private Properties properties;

  public ConfigPropertiesFile() {
    properties = new Properties();
    File propertiesFile = new File("src/test/resources/app.properties");
    String absolutePath = propertiesFile.getAbsolutePath();

    try (BufferedReader inputStream = new BufferedReader(new FileReader(absolutePath))) {
      properties.load(inputStream);
    }
    catch (IOException e) {
      System.out.println("Caught IOException: " + e.getMessage());
    }
  }

  public String getEmail() {
    return properties.getProperty("browser");
  }

  public String getPassword() {
    return properties.getProperty("password");
  }
}