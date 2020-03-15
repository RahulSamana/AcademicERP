package app.examinationportal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examination_portal_exams")
public class ExaminationPortalExam {
//PRIVATE VARIABLES
	
    @Id
	@Column(name = "test_id")
	private String sTestId;

	@Column(name = "faculty_registration_number")
	private String sFacultyRegistrationNumber;
    
	@Column(name = "department")
	private String sDepartment;
	
	@Column(name = "year")
	private String sYear;
	
	@Column(name = "semester")
	private String sSemester;
	
	@Column(name = "subject")
	private String sSubject;
	
	@Column(name = "faculty_name")
	private String sFacultyName;
	
	public String getsFacultyRegistrationNumber() {
		return sFacultyRegistrationNumber;
	}

	public void setsFacultyRegistrationNumber(String sFacultyRegistrationNumber) {
		this.sFacultyRegistrationNumber = sFacultyRegistrationNumber;
	}
	
	public String getsDepartment() {
		return sDepartment;
	}

	public void setsDepartment(String sDepartment) {
		this.sDepartment = sDepartment;
	}

	public String getsYear() {
		return sYear;
	}

	public void setsYear(String sYear) {
		this.sYear = sYear;
	}

	public String getsSemester() {
		return sSemester;
	}

	public void setsSemester(String sSemester) {
		this.sSemester = sSemester;
	}

	public String getsSubject() {
		return sSubject;
	}

	public void setsSubject(String sSubject) {
		this.sSubject = sSubject;
	}

	public String getsFacultyName() {
		return sFacultyName;
	}

	public void setsFacultyName(String sFacultyName) {
		this.sFacultyName = sFacultyName;
	}

	public String getsTestId() {
		return sTestId;
	}

	public void setsTestId(String sTestId) {
		this.sTestId = sTestId;
	}


}