package utilities;

public class Locators {

	// Login page
	
	public static final String USER_NAME_FIELD = "//input[@formcontrolname=\"userName\"]";
	public static final String PASSWORD_FIELD = "//input[@formcontrolname=\"password\"]";
	public static final String LOGIN_BUTTON = "//button[@class=\"btn btn-primary w-100\"]";
	
	// Home page
	
	public static final String COMPANY_DATA_MANAGEMENT1 = "https://emdm-ws-uat.houston.hpecorp.net/EMDMUI/#/login";
	public static final String SEARCH_DROPDOWN = "//*[(text()=\'Search\')]";
	public static final String SEARCH_LOCATION = "//*[(text()=\'Search Location\')]";
	public static final String SEARCH_PARTY = "//span[@id=\'advance-search-Party\']";
	
	// Search Location page
	
	public static final String LOCATION_NAME_FIELD = "//input[@formcontrolname=\'name\']";
	public static final String LOCATION_COUNTRY_FIELD_DROPDOWN = "(//select[@formcontrolname=\"country\"])[1]";
	public static final String LOCATION_ADDRESS_LINE1 = "(//input[@formcontrolname=\'addressLine1\'])[1]";
	public static final String LOCATION_LOCATION_NAME = "(//input[@formcontrolname=\'name\'])[1]";
	public static final String LOCATION_CITY = "(//input[@formcontrolname=\'city\'])[1]";
	public static final String LOCATION_POSTAL_CODE = "(//input[@formcontrolname=\"postalCode\"])[1]";
	public static final String LOCATION_SEARCH_BUTTON = "//button[@type=\'submit\']";
	public static final String LOCATION_FRST_RESULT = "(//datatable-body-cell[@tabindex=\"-1\"]//div//span)[2]";
	public static final String LOCATION_RESULT_ADDRESS = "(//input[@id=\"addressLine1\"])[2]";
	public static final String LOCATION_RESULT_NAME = "//input[@id=\"organizationName\"]";
	public static final String LOCATION_RESULT_CITY = "(//input[@id=\"city\"])[2]";
	public static final String LOCATION_RESULT_ZIP = "(//input[@id=\"zip\"])[2]";
	public static final String LOCATION_RESULT_COUNTRY = "//select[@formcontrolname=\"countryCode\"]";
	
	// Search Party page
	
	public static final String PARTY_NAME_FIELD = "(//input[@formcontrolname=\'name\'])[2]";
	public static final String PARTY_COUNTRY_DROPDOWN = "(//select[@formcontrolname=\"country\"])[2]";
	public static final String PARTY_CITY_DROPDOWN = "(//select[@formcontrolname=\"stateProvince\"])[2]";
	public static final String PARTY_SEARCH_BUTTON = "(//button[@class=\'btn btn-primary\'])[4]";
	public static final String PARTY_CITY_FIELD = "(//input[@autocomplete=\'city\'])[2]";
	public static final String PARTY_RESULT_R1 = "(//datatable-row-wrapper)[8]//span[@class=\'ng-star-inserted\']";
	public static final String PARTY_STATE_DROPDOWN = "(//select[@formcontrolname=\"stateProvince\"])[2]";
	
	//Create 
	
	public static final String CREATE_PARTY_FIELD = "//span[@id='create-new-Party']";
	public static final String CREATE_LOACTION_FIELD= "//span[@id='create-new-Location']";
	public static final String CREATE_PARTY_ORGANIZATION = "//input[@id=\"organizationName\"]";
	public static final String CREATE_PARTY_TYPE = "";
	
	public static final String LOGIN_NAME = "/input[contains(@type,\"email\")]";
	
	public static final String LOGIN_PASSWORD = "//input[contains(@type,\"password\")]";
	
	public static final String LOGIN_BUTTON_1 = "//button[contains(@type,\"submit\")]";
	
 
	
}

