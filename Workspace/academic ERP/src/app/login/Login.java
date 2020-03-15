package app.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "login")
public class Login {
	
	//PRIVATE VARIABLES
	
	@Id
	@Column(name = "username")
	private String sUsername;
		
	@Column(name = "password")
	private String sPassword;
    
    @Column(name = "role")
	private String sRole;

	public String getsUsername() {
		return sUsername;
	}

	public void setsUsername(String sUsername) {
		this.sUsername = sUsername;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public String getsRole() {
		return sRole;
	}

	public void setsRole(String sRole) {
		this.sRole = sRole;
	}
    
    
}

