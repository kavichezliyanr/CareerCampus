/**
 * 
 */
package com.career.compass.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Kavichezliyan Rajendran
 *
 */
@Entity
@Table(name="STATEWISE")
public class Statewise implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5587231333812333050L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stateWiseId;
	
	@NotEmpty
	@Column(name="YEAR" , nullable=false)
	private int year;
	
	@NotEmpty
	@Column(name="STATE" , nullable=false)
	private String state;
	
	@NotEmpty
	@Column(name="COURSE" , nullable=false)
	private String course ;
	
	@NotEmpty
	@Column(name="LEVEL" , nullable=false)
	private String level;
	
	@NotEmpty
	@Column(name="PROGRAM" , nullable=false)
	private String program;
	
	@OneToMany( targetEntity=Colleges.class , mappedBy="statewise")
    private List<Colleges> collegeList;

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the collegeList
	 */
	public List<Colleges> getCollegeList() {
		return collegeList;
	}

	/**
	 * @param collegeList the collegeList to set
	 */
	public void setCollegeList(List<Colleges> collegeList) {
		this.collegeList = collegeList;
	}
}
