package model;

public class accountVO {
	private String account;
	private String pswd;
	private String favorite;
	
	
	
	
	
	@Override
	public String toString() {
		return "accountVO [account=" + account + ", pswd=" + pswd + ", favorite=" + favorite + "]";
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	
}
