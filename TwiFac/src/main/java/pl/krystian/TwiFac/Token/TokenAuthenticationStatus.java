package pl.krystian.TwiFac.Token;

public class TokenAuthenticationStatus {
	
	
	private String message;
	private boolean isSuccessed;
	
	
	
	
	public String getMessage() {
		return message;
	}
	public boolean isSuccessed() {
		return isSuccessed;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSuccessed(boolean isSuccessed) {
		this.isSuccessed = isSuccessed;
	}
}
