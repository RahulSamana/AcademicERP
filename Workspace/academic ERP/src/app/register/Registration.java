package app.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "newRegistration")
public class Registration {
	
	//PRIVATE VARIABLES
	
	@Id
	@Column(name = "unique_reference_number")
	private String sUniqueReferenceNumber;
		
	@Column(name = "registration_number")
	private String sRegistrationNumber;
    
    @Column(name = "candidate_type")
	private String sCandidateType;

    @Column(name = "login_role")
	private String sLoginRole;
    
    @Column(name = "course_name")
	private String sCourseName;
    
    @Column(name = "sub_course_name")
	private String sSubCourseName;
    
    @Column(name = "duration_of_course")
   	private String sDurationOfCourse;
    
    @Column(name = "boarding_type")
	private String sBoardingType;
    
    @Column(name = "academic_year")
	private int iAcademicYear;
    
    @Column(name = "academic_semester")
	private String sAcademicSemester;
    
    @Column(name = "designation")
	private String sDesignation;
    
    @Column(name = "full_name")
	private String sFullName;
    
    @Column(name = "admission_type")
	private String sAdmissionType;
    
    @Column(name = "date_of_birth")
	private String sDateOfBirth;
    
    @Column(name = "father_full_name")
	private String sFatherFullName;
    
    @Column(name = "father_occupation")
	private String sFatherOccupation;
    
    @Column(name = "mother_maiden_name")
	private String sMotherMaidenName;
    
    @Column(name = "religion")
	private String sReligion;
    
    @Column(name = "nationality")
	private String sNationality;
    
    @Column(name = "gender")
	private String sGender;
    
    @Column(name = "marital_status")
	private String sMaritalStatus;
    
    @Column(name = "mobile_number")
	private String sMobileNumber;
    
    @Column(name = "email_address")
	private String sEmailAddress;
    
    @Column(name = "temporary_address")
	private String sTemporaryAddress;
    
    @Column(name = "permanent_address")
	private String sPermanentAddress;
    
    @Column(name = "eamcet_rank")
	private String sEamcetRank;
    
    @Column(name = "intermediate_marks")
	private String sIntermediateMarks;
    
    @Column(name = "ssc_marks")
	private String sSSCMarks;
    
    @Column(name = "fee_amount")
 	private String sFeeAmount;

    @Column(name = "fee_payment_status_1_year")
	private String sFeePaymentStatus1stYear;
    
    @Column(name = "fee_payment_status_2_year")
 	private String sFeePaymentStatus2ndYear;
    
    @Column(name = "fee_payment_status_3_year")
 	private String sFeePaymentStatus3rdYear;
    
    @Column(name = "fee_payment_status_4_year")
 	private String sFeePaymentStatus4thYear;
    
    @Column(name = "fee_payment_status_5_year")
 	private String sFeePaymentStatus5thYear;
    
    @Column(name = "fee_payment_status_6_year")
 	private String sFeePaymentStatus6thYear;
    
    @Column(name = "fee_payment_status_7_year")
 	private String sFeePaymentStatus7thYear;
    
    @Column(name = "fee_payment_status_8_year")
 	private String sFeePaymentStatus8thYear;
    
    @Column(name = "fee_payment_status_9_year")
 	private String sFeePaymentStatus9thYear;
    
    @Column(name = "fee_payment_status_10_year")
 	private String sFeePaymentStatus10thYear;
    
    @Column(name = "fee_payment_status_11_year")
 	private String sFeePaymentStatus11thYear;
    
    @Column(name = "fee_payment_status_12_year")
 	private String sFeePaymentStatus12thYear;
    
    @Column(name = "salary_amount")
	private String sSalaryAmount;
    
    @Column(name = "salary_credited_status")
	private String sSalaryCreditedStatus;
    
    @Column(name = "semester_change_count")
	private int iSemesterChangeCount;


	public String getsUniqueReferenceNumber() {
		return sUniqueReferenceNumber;
	}

	public void setsUniqueReferenceNumber(String sUniqueReferenceNumber) {
		this.sUniqueReferenceNumber = sUniqueReferenceNumber;
	}

	public String getsRegistrationNumber() {
		return sRegistrationNumber;
	}

	public void setsRegistrationNumber(String sRegistrationNumber) {
		this.sRegistrationNumber = sRegistrationNumber;
	}

	public String getsCandidateType() {
		return sCandidateType;
	}

	public void setsCandidateType(String sCandidateType) {
		this.sCandidateType = sCandidateType;
	}

	public String getsLoginRole() {
		return sLoginRole;
	}

	public void setsLoginRole(String sLoginRole) {
		this.sLoginRole = sLoginRole;
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
	
	
	public String getsDurationOfCourse() {
		return sDurationOfCourse;
	}

	public void setsDurationOfCourse(String sDurationOfCourse) {
		this.sDurationOfCourse = sDurationOfCourse;
	}

	public String getsBoardingType() {
		return sBoardingType;
	}


	public int getsAcademicYear() {
		return iAcademicYear;
	}

	public void setsAcademicYear(int iAcademicYear) {
		this.iAcademicYear = iAcademicYear;
	}

	public String getsAcademicSemester() {
		return sAcademicSemester;
	}

	public void setsAcademicSemester(String sAcademicSemester) {
		this.sAcademicSemester = sAcademicSemester;
	}

	public void setsBoardingType(String sBoardingType) {
		this.sBoardingType = sBoardingType;
	}

	public String getsDesignation() {
		return sDesignation;
	}

	public void setsDesignation(String sDesignation) {
		this.sDesignation = sDesignation;
	}

	public String getsFullName() {
		return sFullName;
	}

	public void setsFullName(String sFullName) {
		this.sFullName = sFullName;
	}

	public String getsAdmissionType() {
		return sAdmissionType;
	}

	public void setsAdmissionType(String sAdmissionType) {
		this.sAdmissionType = sAdmissionType;
	}

	public String getsDateOfBirth() {
		return sDateOfBirth;
	}

	public void setsDateOfBirth(String sDateOfBirth) {
		this.sDateOfBirth = sDateOfBirth;
	}

	public String getsFatherFullName() {
		return sFatherFullName;
	}

	public void setsFatherFullName(String sFatherFullName) {
		this.sFatherFullName = sFatherFullName;
	}

	public String getsFatherOccupation() {
		return sFatherOccupation;
	}

	public void setsFatherOccupation(String sFatherOccupation) {
		this.sFatherOccupation = sFatherOccupation;
	}

	public String getsMotherMaidenName() {
		return sMotherMaidenName;
	}

	public void setsMotherMaidenName(String sMotherMaidenName) {
		this.sMotherMaidenName = sMotherMaidenName;
	}

	public String getsReligion() {
		return sReligion;
	}

	public void setsReligion(String sReligion) {
		this.sReligion = sReligion;
	}

	public String getsNationality() {
		return sNationality;
	}

	public void setsNationality(String sNationality) {
		this.sNationality = sNationality;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public String getsMaritalStatus() {
		return sMaritalStatus;
	}

	public void setsMaritalStatus(String sMaritalStatus) {
		this.sMaritalStatus = sMaritalStatus;
	}

	public String getsMobileNumber() {
		return sMobileNumber;
	}

	public void setsMobileNumber(String sMobileNumber) {
		this.sMobileNumber = sMobileNumber;
	}

	public String getsEmailAddress() {
		return sEmailAddress;
	}

	public void setsEmailAddress(String sEmailAddress) {
		this.sEmailAddress = sEmailAddress;
	}

	public String getsTemporaryAddress() {
		return sTemporaryAddress;
	}

	public void setsTemporaryAddress(String sTemporaryAddress) {
		this.sTemporaryAddress = sTemporaryAddress;
	}

	public String getsPermanentAddress() {
		return sPermanentAddress;
	}

	public void setsPermanentAddress(String sPermanentAddress) {
		this.sPermanentAddress = sPermanentAddress;
	}

	public String getsEamcetRank() {
		return sEamcetRank;
	}

	public void setsEamcetRank(String sEamcetRank) {
		this.sEamcetRank = sEamcetRank;
	}

	public String getsIntermediateMarks() {
		return sIntermediateMarks;
	}

	public void setsIntermediateMarks(String sIntermediateMarks) {
		this.sIntermediateMarks = sIntermediateMarks;
	}

	public String getsSSCMarks() {
		return sSSCMarks;
	}

	public void setsSSCMarks(String sSSCMarks) {
		this.sSSCMarks = sSSCMarks;
	}



	public int getiAcademicYear() {
		return iAcademicYear;
	}

	public void setiAcademicYear(int iAcademicYear) {
		this.iAcademicYear = iAcademicYear;
	}

	public String getsFeePaymentStatus1stYear() {
		return sFeePaymentStatus1stYear;
	}

	public void setsFeePaymentStatus1stYear(String sFeePaymentStatus1stYear) {
		this.sFeePaymentStatus1stYear = sFeePaymentStatus1stYear;
	}

	public String getsFeePaymentStatus2ndYear() {
		return sFeePaymentStatus2ndYear;
	}

	public void setsFeePaymentStatus2ndYear(String sFeePaymentStatus2ndYear) {
		this.sFeePaymentStatus2ndYear = sFeePaymentStatus2ndYear;
	}

	public String getsFeePaymentStatus3rdYear() {
		return sFeePaymentStatus3rdYear;
	}

	public void setsFeePaymentStatus3rdYear(String sFeePaymentStatus3rdYear) {
		this.sFeePaymentStatus3rdYear = sFeePaymentStatus3rdYear;
	}

	public String getsFeePaymentStatus4thYear() {
		return sFeePaymentStatus4thYear;
	}

	public void setsFeePaymentStatus4thYear(String sFeePaymentStatus4thYear) {
		this.sFeePaymentStatus4thYear = sFeePaymentStatus4thYear;
	}

	public String getsFeePaymentStatus5thYear() {
		return sFeePaymentStatus5thYear;
	}

	public void setsFeePaymentStatus5thYear(String sFeePaymentStatus5thYear) {
		this.sFeePaymentStatus5thYear = sFeePaymentStatus5thYear;
	}

	public String getsFeePaymentStatus6thYear() {
		return sFeePaymentStatus6thYear;
	}

	public void setsFeePaymentStatus6thYear(String sFeePaymentStatus6thYear) {
		this.sFeePaymentStatus6thYear = sFeePaymentStatus6thYear;
	}

	public String getsFeePaymentStatus7thYear() {
		return sFeePaymentStatus7thYear;
	}

	public void setsFeePaymentStatus7thYear(String sFeePaymentStatus7thYear) {
		this.sFeePaymentStatus7thYear = sFeePaymentStatus7thYear;
	}

	public String getsFeePaymentStatus8thYear() {
		return sFeePaymentStatus8thYear;
	}

	public void setsFeePaymentStatus8thYear(String sFeePaymentStatus8thYear) {
		this.sFeePaymentStatus8thYear = sFeePaymentStatus8thYear;
	}

	public String getsFeePaymentStatus9thYear() {
		return sFeePaymentStatus9thYear;
	}

	public void setsFeePaymentStatus9thYear(String sFeePaymentStatus9thYear) {
		this.sFeePaymentStatus9thYear = sFeePaymentStatus9thYear;
	}

	public String getsFeePaymentStatus10thYear() {
		return sFeePaymentStatus10thYear;
	}

	public void setsFeePaymentStatus10thYear(String sFeePaymentStatus10thYear) {
		this.sFeePaymentStatus10thYear = sFeePaymentStatus10thYear;
	}

	public String getsFeePaymentStatus11thYear() {
		return sFeePaymentStatus11thYear;
	}

	public void setsFeePaymentStatus11thYear(String sFeePaymentStatus11thYear) {
		this.sFeePaymentStatus11thYear = sFeePaymentStatus11thYear;
	}

	public String getsFeePaymentStatus12thYear() {
		return sFeePaymentStatus12thYear;
	}

	public void setsFeePaymentStatus12thYear(String sFeePaymentStatus12thYear) {
		this.sFeePaymentStatus12thYear = sFeePaymentStatus12thYear;
	}

	public String getsFeeAmount() {
		return sFeeAmount;
	}

	public void setsFeeAmount(String sFeeAmount) {
		this.sFeeAmount = sFeeAmount;
	}

	public String getsSalaryAmount() {
		return sSalaryAmount;
	}

	public void setsSalaryAmount(String sSalaryAmount) {
		this.sSalaryAmount = sSalaryAmount;
	}

	public String getsSalaryCreditedStatus() {
		return sSalaryCreditedStatus;
	}

	public void setsSalaryCreditedStatus(String sSalaryCreditedStatus) {
		this.sSalaryCreditedStatus = sSalaryCreditedStatus;
	}

	public int getiSemesterChangeCount() {
		return iSemesterChangeCount;
	}

	public void setiSemesterChangeCount(int iSemesterChangeCount) {
		this.iSemesterChangeCount = iSemesterChangeCount;
	}


    

}