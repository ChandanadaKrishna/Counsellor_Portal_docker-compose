package in.ashokit.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enquiry_tbl")
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String studentname;
	private String studentphone;
	private String classmode;
	private String coursename;
	private String enqstatus;
	
	@CreationTimestamp
	private LocalDate createdate;
	
	@UpdateTimestamp
	private LocalDate updatedate;
	
	@ManyToOne
	@JoinColumn(name="counsellorId")
	private Counsellor counsellor;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentphone() {
		return studentphone;
	}

	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}

	public String getClassmode() {
		return classmode;
	}

	public void setClassmode(String classmode) {
		this.classmode = classmode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getEnqstatus() {
		return enqstatus;
	}

	public void setEnqstatus(String enqstatus) {
		this.enqstatus = enqstatus;
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

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	
	
}
