package app.idcard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "idcard")
public class IDCard {
	
	//PRIVATE VARIABLES
	
	@Id
	@Column(name = "unique_request_number")
	private String sUniqueRequestNumber;
		
	@Column(name = "department")
	private String sDepartment;
	
	@Column(name = "roll_no")
	private String sRollNo;
    
    @Column(name = "blood_group")
	private String sBloodGroup;
    
    @Column(name = "full_name")
   	private String sFullName;
    
    @Column(name = "mobile_number")
   	private String sMobileNumber;
    
    @Column(name = "date_of_birth")
   	private String sDateOfBirth;
    
    @Column(name = "address")
   	private String sAddress;
    
    @Column(name = "request_status")
   	private String sRequestStatus;
    

	public String getsUniqueRequestNumber() {
		return sUniqueRequestNumber;
	}

	public void setsUniqueRequestNumber(String sUniqueRequestNumber) {
		this.sUniqueRequestNumber = sUniqueRequestNumber;
	}

	public String getsDepartment() {
		return sDepartment;
	}

	public void setsDepartment(String sDepartment) {
		this.sDepartment = sDepartment;
	}

	public String getsBloodGroup() {
		return sBloodGroup;
	}

	public void setsBloodGroup(String sBloodGroup) {
		this.sBloodGroup = sBloodGroup;
	}

	public String getsFullName() {
		return sFullName;
	}

	public void setsFullName(String sFullName) {
		this.sFullName = sFullName;
	}

	public String getsMobileNumber() {
		return sMobileNumber;
	}

	public void setsMobileNumber(String sMobileNumber) {
		this.sMobileNumber = sMobileNumber;
	}

	public String getsDateOfBirth() {
		return sDateOfBirth;
	}

	public void setsDateOfBirth(String sDateOfBirth) {
		this.sDateOfBirth = sDateOfBirth;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsRequestStatus() {
		return sRequestStatus;
	}

	public void setsRequestStatus(String sRequestStatus) {
		this.sRequestStatus = sRequestStatus;
	}

	public String getsRollNo() {
		return sRollNo;
	}

	public void setsRollNo(String sRollNo) {
		this.sRollNo = sRollNo;
	}
	
	
    
    

	
    
}

