package utilities;

public class Properties {

	
	public static final String screenshotPath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path + "\\Reports";
	}
	
	
	public static final String LOGIN_NAME = "lakshmi-naryana.gogineni@hpe.com";
	
	public static final String LOGIN_PASSWORD = "Password_06";
	
	
}
