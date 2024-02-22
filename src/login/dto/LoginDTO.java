package login.dto;

public class LoginDTO {
	private String id, pwd;
	private int secret = 1213;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	
}
