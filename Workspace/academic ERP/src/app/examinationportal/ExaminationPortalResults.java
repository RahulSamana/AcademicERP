package app.examinationportal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "examination_portal_results")
public class ExaminationPortalResults implements Serializable{
//PRIVATE VARIABLES
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entry")
	private String sEntry;
	
	@Column(name = "test_id")
	private String sTestId;
	
	@Column(name = "registration_number")
	private String sRegistrationNumber;
	
	@Column(name = "subject")
	private String sSubject;
	
	@Column(name = "faculty_name")
	private String sFacultyName;
	
	@Column(name = "marks_obtained")
	private String sMarksObtained;
	
	@Column(name = "test_attempted_date")
	private String sTestAttemptedDate;

	@Column(name = "number_of_attempts")
	private String sNumberofAttempts;

	public String getsTestId() {
		return sTestId;
	}

	public void setsTestId(String sTestId) {
		this.sTestId = sTestId;
	}

	public String getsRegistrationNumber() {
		return sRegistrationNumber;
	}

	public void setsRegistrationNumber(String sRegistrationNumber) {
		this.sRegistrationNumber = sRegistrationNumber;
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

	public String getsMarksObtained() {
		return sMarksObtained;
	}

	public void setsMarksObtained(String sMarksObtained) {
		this.sMarksObtained = sMarksObtained;
	}
	
	public String getsTestAttemptedDate() {
		return sTestAttemptedDate;
	}

	public void setsTestAttemptedDate(String sTestAttemptedDate) {
		this.sTestAttemptedDate = sTestAttemptedDate;
	}

	public String getsNumberofAttempts() {
		return sNumberofAttempts;
	}

	public void setsNumberofAttempts(String sNumberofAttempts) {
		this.sNumberofAttempts = sNumberofAttempts;
	}
	
}
