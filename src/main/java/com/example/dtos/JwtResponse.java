package com.example.dtos;

public class JwtResponse {
	private String accesstoken;
	private String refreshtoken;
	private String tokentype= "Bearer";
	
	public JwtResponse(String accesstoken, String refreshtoken) {
		this.setAccesstoken(accesstoken);
		this.setRefreshtoken(refreshtoken);
		
		
	}

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public String getRefreshtoken() {
		return refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public String getTokentype() {
		return tokentype;
	}

	public void setTokentype(String tokentype) {
		this.tokentype = tokentype;
	}
}
