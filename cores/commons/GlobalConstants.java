package commons;

public class GlobalConstants {
	//System info
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	
	
	// Additional info for user: Variables are used generally for all classes
	public static final String DEV_USER_URL = "https://dev.techpanda.org/";
	public static final String STAGING_USER_URL = "https://staging.techpanda.org/";
	public static final String LIVE_USER_URL = "https://live.techpanda.org/";
	
	// Additional info for Admin
	public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin/";
	public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin/";
	public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin/";
	
	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";
	
	// Wait Info
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	
	// Download/ Upload file
	public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles/";
	public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/";
	
	// Retry Failed test cases
	public static final int RETRY_NUMBER = 3;
	
	// Browser logs/ Extension
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
	public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";
	
	// html report Folder
	public static final String REPORTNG_PATH = PROJECT_PATH + "/htmlReportNG/";
	public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
	public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";
}
