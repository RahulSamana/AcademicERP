package app.examinationportal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.*;

@Entity
@Table(name = "examination_portal_questions")
public class ExaminationPortalQuestions {
//PRIVATE VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_number")
	private String sQuestionNumber;
	
	
	@Column(name = "test_id")
	private String sTestId;
	
	public String getsQuestionNumber() {
		return sQuestionNumber;
	}

	public void setsQuestionNumber(String sQuestionNumber) {
		this.sQuestionNumber = sQuestionNumber;
	}

	@Column(name = "question")
	private String sQuestion;
	
	@Column(name = "option_1")
	private String sOption1;
	
	@Column(name = "option_2")
	private String sOption2;
	
	@Column(name = "option_3")
	private String sOption3;
	
	@Column(name = "option_4")
	private String sOption4;
	

	public String getsTestId() {
		return sTestId;
	}

	public void setsTestId(String sTestId) {
		this.sTestId = sTestId;
	}

	public String getsQuestion() {
		return sQuestion;
	}

	public void setsQuestion(String sQuestion) {
		this.sQuestion = sQuestion;
	}

	public String getsOption1() {
		return sOption1;
	}

	public void setsOption1(String sOption1) {
		this.sOption1 = sOption1;
	}

	public String getsOption2() {
		return sOption2;
	}

	public void setsOption2(String sOption2) {
		this.sOption2 = sOption2;
	}

	public String getsOption3() {
		return sOption3;
	}

	public void setsOption3(String sOption3) {
		this.sOption3 = sOption3;
	}

	public String getsOption4() {
		return sOption4;
	}

	public void setsOption4(String sOption4) {
		this.sOption4 = sOption4;
	}

	public String getsRightAnswer() {
		return sRightAnswer;
	}

	public void setsRightAnswer(String sRightAnswer) {
		this.sRightAnswer = sRightAnswer;
	}

	@Column(name = "right_answer")
	private String sRightAnswer;
}