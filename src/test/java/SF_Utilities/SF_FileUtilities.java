package SF_Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import SF_Cona.SF_ConstantFiles;

public class SF_FileUtilities {
	public static String readLoginPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(SF_ConstantFiles.LOGIN_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}

	public static String readHomePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(SF_ConstantFiles.HOME_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}
}
