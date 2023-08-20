package tests.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Builder

public class OauthClass {

	private String grant_type;
	private String client_id;
	private String client_secret;
	private String username;
	private String password;
	
}
