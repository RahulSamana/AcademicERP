package app.resetpassword;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reset_password")
public class ResetPassword {
	
	//PRIVATE VARIABLES
	
    @Id
	@Column(name = "email")
	private String sEmail;
    
    @Column(name = "code")
	private String sCode;

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
    
    
    
}