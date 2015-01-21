package org.lightadmin.demo.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.util.Assert;


@Entity
public class Fighter extends AbstractEntity {
	@Column
	private String firstname;

	@Column
	private String lastname;

    @Column 
	private String emailAddress;

    //TODO: adjust it properly
    @Column(name = "REG_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOfBirth;

    @Column
	private String address;
    
    @Column
    private String parentsPhone;
    
    @Column
    private String district;

    @Column
    private String grade;
    
    @Column
    private String parentsName;
    
    @Column
    private String fights;

    //TODO: add avatar as blob
//    @Column(name = "AVATAR_FILE_URL")
//    @FileReference(baseDirectory = "D:\\deleteMe\\lightadmin-demo")
//    private String avatar;

    
	public Fighter( String firstname, String lastname ) {
		Assert.hasText( firstname );
		Assert.hasText( lastname );

		this.setFirstname(firstname);
		this.setLastname(lastname);
	}

	public Fighter() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getFights() {
		return fights;
	}

	public void setFights(String fights) {
		this.fights = fights;
	}

	public String getParentsPhone() {
		return parentsPhone;
	}

	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}
}
