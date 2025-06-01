package SF_Utilities;

import java.io.*;
import java.util.*;

import org.openqa.selenium.Cookie;

import SF_Cona.SF_ConstantFiles;

public class SF_FileUtilities {

	// Read login properties file
	public static String readLoginPropertiesFile(String key) throws IOException {
		return readPropertiesFile(SF_ConstantFiles.LOGIN_TEST_DATA_FILE_PATH, key);
	}

	// Read home properties file
	public static String readHomePropertiesFile(String key) throws IOException {
		return readPropertiesFile(SF_ConstantFiles.HOME_TEST_DATA_FILE_PATH, key);
	}

	// Read home leads link file
	public static String readHomeLeadsLinkFile(String key) throws IOException {
		return readPropertiesFile(SF_ConstantFiles.LEADS_LINK_DROPDOWN, key);
	}

	// Generic method to read properties file
	private static String readPropertiesFile(String filePath, String key) throws IOException {
		Properties properties = new Properties();
		try (FileReader reader = new FileReader(filePath)) {
			properties.load(reader);
		}
		return properties.getProperty(key);
	}

	// Write cookies to file
	public static void writeCookiesToFile(Set<Cookie> cookies, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Cookie cookie : cookies) {
				writer.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" +
						cookie.getPath() + ";" + (cookie.getExpiry() != null ? cookie.getExpiry().getTime() : "null")
						+ ";" +
						cookie.isSecure());
				writer.newLine();
			}
		}
		System.out.println("Cookies saved successfully to " + filePath);
	}

	// Read cookies from file
	public static Set<Cookie> readCookiesFromFile(String filePath) throws IOException {
		Set<Cookie> cookies = new HashSet<>();
		File cookieFile = new File(filePath);

		// Check if file exists and is not empty
		if (!cookieFile.exists() || cookieFile.length() == 0) {
			System.out.println("Cookie file is empty or missing.");
			return cookies;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length >= 6) {
					String name = parts[0];
					String value = parts[1];
					String domain = parts[2];
					String path = parts[3];
					Date expiry = parts[4].equals("null") ? null : new Date(Long.parseLong(parts[4]));
					boolean isSecure = Boolean.parseBoolean(parts[5]);

					Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
					cookies.add(cookie);
				}
			}
		}
		System.out.println("Cookies loaded from " + filePath + ": " + cookies);
		return cookies;
	}
}
