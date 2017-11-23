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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Kavichezliyan Rajendran
 *
 */
@Entity
@Table(name="COLLEGES")
public class Colleges implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5586595292700910790L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int collegeId;
	
	@NotEmpty
	@Column(name="AICTEID" , nullable=false)
	private String aicteId;
	
	@NotEmpty
	@Column(name="NAME" , nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="DISTRICT" , nullable=false)
	private String district;
	
	@NotEmpty
	@Column(name="INSTITUTIONTYPE" , nullable=false)
	private String institutionType;
	
	@NotEmpty
	@Column(name="WOMEN" , nullable=false)
	private String women;
	
	@NotEmpty
	@Column(name="MINORITY" , nullable=false)
	private String minority;
	
	@OneToMany( targetEntity=Courses.class , mappedBy="colleges")
    private List<Courses> courseList;
	
	@ManyToOne
    private Statewise statewise;

	/**
	 * @return the aicteId
	 */
	public String getAicteId() {
		return aicteId;
	}

	/**
	 * @param aicteId the aicteId to set
	 */
	public void setAicteId(String aicteId) {
		this.aicteId = aicteId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the institutionType
	 */
	public String getInstitutionType() {
		return institutionType;
	}

	/**
	 * @param institutionType the institutionType to set
	 */
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	/**
	 * @return the women
	 */
	public String getWomen() {
		return women;
	}

	/**
	 * @param women the women to set
	 */
	public void setWomen(String women) {
		this.women = women;
	}

	/**
	 * @return the minority
	 */
	public String getMinority() {
		return minority;
	}

	/**
	 * @param minority the minority to set
	 */
	public void setMinority(String minority) {
		this.minority = minority;
	}

	/**
	 * @return the courseList
	 */
	public List<Courses> getCourseList() {
		return courseList;
	}

	/**
	 * @param courseList the courseList to set
	 */
	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}

	/**
	 * @return the statewise
	 */
	public Statewise getStatewise() {
		return statewise;
	}

	/**
	 * @param statewise the statewise to set
	 */
	public void setStatewise(Statewise statewise) {
		this.statewise = statewise;
	}
	 

}
