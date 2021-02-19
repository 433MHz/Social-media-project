package pl.krystian.TwiFac.config;

public class Config {
	public static final int LOGIN_MAX_LENGTH = 30;
	public static final int LOGIN_MIN_LENGTH = 5;
	public static final String LOGIN_ALLOWED_SIGNS = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	public static final String PASSWORD_ALLOWED_SIGNS = LOGIN_ALLOWED_SIGNS + "!@#$%^&*()_-+=";
	public static final int PASSWORD_MAX_LENGTH = 30;
	public static final int PASSWORD_MIN_LENGTH = 5;
	public static final String DATABASE_TABLE_NAME = "";
	public static final String TOKEN_ALLOWED_SIGNS = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()";
	public static final int TOKEN_LENGTH = 160;
	
	
	

}
