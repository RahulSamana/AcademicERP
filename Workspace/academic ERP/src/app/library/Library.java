package app.library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "library")
public class Library {
	
	//PRIVATE VARIABLES
	
	@Id
	@Column(name = "unique_reference_number")
	private String sUniqueReferenceNumber;
		
	@Column(name = "book_name")
	private String sBookName;
    
    @Column(name = "author_1")
	private String sAuthor1;
    
    @Column(name = "author_2")
	private String sAuthor2;
    
    @Column(name = "author_3")
	private String sAuthor3;
    
    @Column(name = "course_name")
	private String sCourseName;
    
    @Column(name = "sub_course_name")
	private String sSubCourseName;
    
    @Column(name = "issued_status")
	private String sIssuedStatus;
    
    @Column(name = "issued_date")
	private String sIssuedDate;
    
    @Column(name = "issued_to_registration_number")
	private String sIssuedToRegistrationNumber;
    
    @Column(name = "issued_to_email_address")
	private String sIssuedToEmailAddress;

    @Column(name = "issued_to_mobile_number")
	private String sIssuedToMobileNumber;

    @Column(name = "renewal_date")
	private String sRenewalDate;

	public String getsUniqueReferenceNumber() {
		return sUniqueReferenceNumber;
	}

	public void setsUniqueReferenceNumber(String sUniqueReferenceNumber) {
		this.sUniqueReferenceNumber = sUniqueReferenceNumber;
	}

	public String getsBookName() {
		return sBookName;
	}

	public void setsBookName(String sBookName) {
		this.sBookName = sBookName;
	}

	public String getsAuthor1() {
		return sAuthor1;
	}

	public void setsAuthor1(String sAuthor1) {
		this.sAuthor1 = sAuthor1;
	}

	public String getsAuthor2() {
		return sAuthor2;
	}

	public void setsAuthor2(String sAuthor2) {
		this.sAuthor2 = sAuthor2;
	}

	public String getsAuthor3() {
		return sAuthor3;
	}

	public void setsAuthor3(String sAuthor3) {
		this.sAuthor3 = sAuthor3;
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

	public String getsIssuedStatus() {
		return sIssuedStatus;
	}

	public void setsIssuedStatus(String sIssuedStatus) {
		this.sIssuedStatus = sIssuedStatus;
	}

	public String getsIssuedDate() {
		return sIssuedDate;
	}

	public void setsIssuedDate(String sIssuedDate) {
		this.sIssuedDate = sIssuedDate;
	}

	public String getsIssuedToRegistrationNumber() {
		return sIssuedToRegistrationNumber;
	}

	public void setsIssuedToRegistrationNumber(String sIssuedToRegistrationNumber) {
		this.sIssuedToRegistrationNumber = sIssuedToRegistrationNumber;
	}

	public String getsIssuedToEmailAddress() {
		return sIssuedToEmailAddress;
	}

	public void setsIssuedToEmailAddress(String sIssuedToEmailAddress) {
		this.sIssuedToEmailAddress = sIssuedToEmailAddress;
	}

	public String getsIssuedToMobileNumber() {
		return sIssuedToMobileNumber;
	}

	public void setsIssuedToMobileNumber(String sIssuedToMobileNumber) {
		this.sIssuedToMobileNumber = sIssuedToMobileNumber;
	}

	public String getsRenewalDate() {
		return sRenewalDate;
	}

	public void setsRenewalDate(String sRenewalDate) {
		this.sRenewalDate = sRenewalDate;
	}
    

	
    
}

