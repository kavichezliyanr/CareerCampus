/**
 * 
 */
package com.career.compass.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Kavichezliyan Rajendran
 *
 */
@Entity
@Table(name="COURSES")
public class Courses implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4386660812003943283L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	
	@NotEmpty
	@Column(name="PROGRAMME" , nullable=false)
	private String Programme;
	
	@NotEmpty
	@Column(name="UNIVERSITY" , nullable=false)
	private String university;
	
	@NotEmpty
	@Column(name="LEVEL" , nullable=false)
	private String level;
	
	@NotEmpty
	@Column(name="FULLORPARTTIME" , nullable=false)
	private String fullOrPartTime ;
	
	@NotEmpty
	@Column(name="INTAKE" , nullable=false)
	private int Intake;
	
	@NotEmpty
	@Column(name="ENROLLMENT" , nullable=false)
	private int enrollment;
	
	@ManyToOne
    private Colleges colleges;

	/**
	 * @return the programme
	 */
	public String getProgramme() {
		return Programme;
	}

	/**
	 * @param programme the programme to set
	 */
	public void setProgramme(String programme) {
		Programme = programme;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the fullOrPartTime
	 */
	public String getFullOrPartTime() {
		return fullOrPartTime;
	}

	/**
	 * @param fullOrPartTime the fullOrPartTime to set
	 */
	public void setFullOrPartTime(String fullOrPartTime) {
		this.fullOrPartTime = fullOrPartTime;
	}

	/**
	 * @return the intake
	 */
	public int getIntake() {
		return Intake;
	}

	/**
	 * @param intake the intake to set
	 */
	public void setIntake(int intake) {
		Intake = intake;
	}

	/**
	 * @return the enrollment
	 */
	public int getEnrollment() {
		return enrollment;
	}

	/**
	 * @param enrollment the enrollment to set
	 */
	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}
	
	
		
	
	

}
