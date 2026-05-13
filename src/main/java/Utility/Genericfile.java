package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Genericfile {

	public String propertyutlityfile(String key) throws IOException {

		// fetch data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/Common.properties");
		Properties pop = new Properties();
		pop.load(fis);
		String value = pop.getProperty(key);
		return value;
	}

}
