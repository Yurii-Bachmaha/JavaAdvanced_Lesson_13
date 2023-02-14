package task01.dto;

public class UserLogin {
	public String email;
	public String destinationUrl;

	public UserLogin(String email, String destinationUrl) {
		this.email = email;
		this.destinationUrl = destinationUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDestinationUrl() {
		return destinationUrl;
	}

	public void setDestinationUrl(String destinationUrl) {
		this.destinationUrl = destinationUrl;
	}

}