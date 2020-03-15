package app.studentportal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_portal_requests")
public class StudentPortal {
	
	//PRIVATE VARIABLES
	
    @Id
	@Column(name = "request_id")
	private String sRequestId;
    
	@Column(name = "date_of_request")
	private String sDateOfRequest;
    
    @Column(name = "request_category")
	private String sRequestCategory;

	@Column(name = "registration_number")
	private String sRegistrationNumber;
    
    @Column(name = "student_name")
	private String sStudentName;
    
    @Column(name = "faculty_name")
	private String sFacultyName;
    
    
    @Column(name = "department")
	private String sDepartment;
    
    @Column(name = "request")
	private String sRequest;

	public String getsRequestId() {
		return sRequestId;
	}

	public void setsRequestId(String sRequestId) {
		this.sRequestId = sRequestId;
	}

    public String getsRequestCategory() {
		return sRequestCategory;
	}

	public void setsRequestCategory(String sRequestCategory) {
		this.sRequestCategory = sRequestCategory;
	}
	
	public String getsRegistrationNumber() {
		return sRegistrationNumber;
	}

	public void setsRegistrationNumber(String sRegistrationNumber) {
		this.sRegistrationNumber = sRegistrationNumber;
	}

	public String getsStudentName() {
		return sStudentName;
	}

	public void setsStudentName(String sStudentName) {
		this.sStudentName = sStudentName;
	}
	
	

	public String getsFacultyName() {
		return sFacultyName;
	}

	public void setsFacultyName(String sFacultyName) {
		this.sFacultyName = sFacultyName;
	}

	public String getsDepartment() {
		return sDepartment;
	}

	public void setsDepartment(String sDepartment) {
		this.sDepartment = sDepartment;
	}

	public String getsRequest() {
		return sRequest;
	}

	public void setsRequest(String sRequest) {
		this.sRequest = sRequest;
	}

	public String getsDateOfRequest() {
		return sDateOfRequest;
	}

	public void setsDateOfRequest(String sDateOfRequest) {
		this.sDateOfRequest = sDateOfRequest;
	}

    
    
}
