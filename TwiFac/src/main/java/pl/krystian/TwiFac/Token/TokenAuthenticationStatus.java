package pl.krystian.TwiFac.Token;

public class TokenAuthenticationStatus {

	private String message;
	private boolean isSuccessed;
	private int id;
	
	
	
	public String getMessage() {
		return message;
	}
	public boolean isSuccessed() {
		return isSuccessed;
	}
	public int getId() {
		return id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSuccessed(boolean isSuccessed) {
		this.isSuccessed = isSuccessed;
	}
	public void setId(int id) {
		this.id = id;
	}
}
