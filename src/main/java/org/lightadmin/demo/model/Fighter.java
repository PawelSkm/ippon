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

    @Embedded    
	private EmailAddress emailAddress;

    //TODO: adjust it properly
    @Column(name = "REG_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOfBirth;

    @Column
	private String address;
    
    @Column
    private String district;

    @Column
    private String grade;

    //TODO: add avatar as blob
//    @Column(name = "AVATAR_FILE_URL")
//    @FileReference(baseDirectory = "D:\\deleteMe\\lightadmin-demo")
//    private String avatar;

    //TODO walki zmienic na konkretne encje
    @Column
    private String fight;
    
	public Fighter( String firstname, String lastname ) {
		Assert.hasText( firstname );
		Assert.hasText( lastname );

		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Fighter() {
	}
}
