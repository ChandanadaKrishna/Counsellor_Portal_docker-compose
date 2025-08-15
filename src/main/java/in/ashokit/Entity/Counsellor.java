package in.ashokit.Entity;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="counsellor_tbl")
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellorId;
	
	@NotEmpty(message = "name is mandatory")
	@Size(min = 5,max = 10,message="name consists of min 5 max 10 characters")
	private String name;
	
	@NotEmpty(message = "PhoneNumber is mandatory")
	private String phonenumber;
	
	@Column(unique = true)
	@Email(message = "provide valid email id")
	@NotEmpty(message = "email is mandatory")
	private String email;
	
	@NotEmpty(message = "password is mandatory")
	private String password;
	
	@CreationTimestamp
	private LocalDate createdate;
	
	@UpdateTimestamp
	private LocalDate updatedate;

	public Integer getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public LocalDate getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}
	

}
