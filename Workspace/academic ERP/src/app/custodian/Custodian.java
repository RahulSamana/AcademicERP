package app.custodian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "custodian")
public class Custodian {
	
	//PRIVATE VARIABLES
	
	@Id
	@Column(name = "unique_request_number")
	private String sUniqueRequestNumber;
		
	@Column(name = "student_full_name")
	private String sStudentFullName;
	
	@Column(name = "father_full_name")
	private String sFatherFullName;
	
	@Column(name = "roll_no")
	private String sRollNo;
	
	@Column(name = "date_of_birth")
	private String sDateOfBirth;
	
	@Column(name = "course_name")
	private String sCourseName;
	
	@Column(name = "sub_course_name")
	private String sSubCourseName;
	
	@Column(name = "course_year")
	private String sCourseYear;
	
	@Column(name = "course_semester")
	private String sCourseSemester;
	
	@Column(name = "academic_year")
	private String sAcademicYear;
	
	@Column(name = "purpose")
	private String sPurpose;

	@Column(name = "request_status")
	private String sRequestStatus;

	public String getsUniqueRequestNumber() {
		return sUniqueRequestNumber;
	}

	public void setsUniqueRequestNumber(String sUniqueRequestNumber) {
		this.sUniqueRequestNumber = sUniqueRequestNumber;
	}

	public String getsStudentFullName() {
		return sStudentFullName;
	}

	public void setsStudentFullName(String sStudentFullName) {
		this.sStudentFullName = sStudentFullName;
	}

	public String getsFatherFullName() {
		return sFatherFullName;
	}

	public void setsFatherFullName(String sFatherFullName) {
		this.sFatherFullName = sFatherFullName;
	}

	public String getsRollNo() {
		return sRollNo;
	}

	public void setsRollNo(String sRollNo) {
		this.sRollNo = sRollNo;
	}

	public String getsDateOfBirth() {
		return sDateOfBirth;
	}

	public void setsDateOfBirth(String sDateOfBirth) {
		this.sDateOfBirth = sDateOfBirth;
	}

	public String getsCourseName() {
		return sCourseName;
	}

	public void setsCourseName(String sCourseName) {
		this.sCourseName = sCourseName;
	}

	public String getsSubCourseName() {
		return sSubCourseName;
	}

	public void setsSubCourseName(String sSubCourseName) {
		this.sSubCourseName = sSubCourseName;
	}

	public String getsCourseYear() {
		return sCourseYear;
	}

	public void setsCourseYear(String sCourseYear) {
		this.sCourseYear = sCourseYear;
	}

	public String getsCourseSemester() {
		return sCourseSemester;
	}

	public void setsCourseSemester(String sCourseSemester) {
		this.sCourseSemester = sCourseSemester;
	}

	public String getsAcademicYear() {
		return sAcademicYear;
	}

	public void setsAcademicYear(String sAcademicYear) {
		this.sAcademicYear = sAcademicYear;
	}

	public String getsPurpose() {
		return sPurpose;
	}

	public void setsPurpose(String sPurpose) {
		this.sPurpose = sPurpose;
	}

	public String getsRequestStatus() {
		return sRequestStatus;
	}

	public void setsRequestStatus(String sRequestStatus) {
		this.sRequestStatus = sRequestStatus;
	}
	
	
	
}
