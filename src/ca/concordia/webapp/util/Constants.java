package ca.concordia.webapp.util;

public final class Constants {
	public static final String ROOT_PATH = "/Flight_API";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/assignment_project";
	public static final String DB_USER_NAME = "root";
	public static final String DB_PASSWORD = "";
	public static final String DB_TABLE_NAME = "flight_data";

	public static final int STATUS_ERROR = 0; 
	public static final int STATUS_INSERTED = 1; 
	public static final int STATUS_UPDATED = 2; 
	public static final int STATUS_DELETED = 3; 
	public static final int STATUS_NORMAL = 4; 
	
	public static final String API_KEY = "YOUR-API-KEY";
	public static final String API_FLIGHT = "https://airlabs.co/api/v9/flights?_view=array&_fields=flight_number,hex,reg_number,flag,lat,lng,alt,arr_iata,dep_iata,speed,status&api_key="+ API_KEY;
	public static final int FLIGHT_LIMIT = 50;

	public static final String[] FLAGS = { "RW", "BG", "LT", "RO", "PT", "KR", "JO", "LV", "AZ", "KG", "MU", "RE", "NA",
			"EC", "KH", "GP", "IN", "CL", "DE", "KY", "CY", "IR", "AO", "ID", "ZA", "NL", "LB", "GR", "VU", "US", "MT",
			"PF", "BT", "NZ", "IQ", "SV", "MM", "ET", "UZ", "MV", "AW", "SC", "DZ", "NG", "TH", "BY", "ER", "BN", "YE",
			"SE", "SB", "MZ", "TZ", "NO", "PL", "KE", "ST", "CA", "IS", "PG", "UG", "SI", "UA", "BR", "BO", "SD", "SG",
			"TW", "FI", "GE", "FJ", "SY", "MD", "TG", "SN", "AU", "SM", "MY", "GG", "HU", "DK", "JP", "BE", "EE", "PK",
			"BD", "MX", "VE", "MG", "SK", "BH", "CH", "HK", "LU", "FR", "OM", "ES", "MO", "RS", "AR", "CN", "LK", "DO",
			"UK", "PA", "IM", "RU", "TT", "CO", "IE", "NP", "KZ", "MA", "KW", "AM", "CI", "TJ", "TR", "QA", "IL", "SA",
			"CZ", "VN", "PH", "IT", "LA", "TM", "UY", "TN", "AT", "PE", "HR", "MN", "EG", "ID", "AE" };
	public static final String[] STATUS_TYPES = { "en-route", "landed" };

	public static final String INSERT_QUERY = "INSERT INTO `" + DB_TABLE_NAME
			+ "`(`flight_number`, `hex`, `reg_number`, `lat`, `lng`, `alt`, `arr_iata`, `dep_iata`, `flag`, `speed`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_QUERY = "UPDATE `" + DB_TABLE_NAME
			+ "` SET `hex`=?,`reg_number`=?,`lat`=?,`lng`=?,`alt`=?,`arr_iata`=?,`dep_iata`=?,`flag`=?,`speed`=?,`status`=?,`updated_date`=CURRENT_TIMESTAMP() WHERE flight_number=?";
	public static final String DELETE_QUERY = "UPDATE " + DB_TABLE_NAME + " SET is_active=0 where flight_number=?;";
	public static final String RETRIEVE_ALL_QUERY = "SELECT * FROM " + DB_TABLE_NAME
			+ " WHERE is_active=1 order by created_date desc;";
	public static final String RETRIEVE_ONE_QUERY = "SELECT * FROM " + DB_TABLE_NAME
			+ " WHERE flight_number=? and is_active=1;";
}
