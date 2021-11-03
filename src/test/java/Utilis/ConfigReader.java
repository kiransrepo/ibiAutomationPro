package Utilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties doReadProperties() {

		FileInputStream fis=null;
		Properties prop=null;

		try {
			//fis = new FileInputStream("./src/test/resources/config.properties");
			prop = new Properties();
			prop.load(ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

}
