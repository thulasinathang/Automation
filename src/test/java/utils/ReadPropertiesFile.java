package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public void readProperties() {

		// Load the properties file in reader
		FileReader reader = null;
		try {
			reader = new FileReader("config.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found");
			e.printStackTrace();
		}
        // load and read the values in properties file
		Properties properties = new Properties();
		try {
			properties.load(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}

		// storing the values into constants class variables
		Constants.Browser = properties.getProperty("browser");
		Constants.URL = properties.getProperty("url");

	}
}