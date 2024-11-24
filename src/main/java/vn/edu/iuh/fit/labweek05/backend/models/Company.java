package vn.edu.iuh.fit.labweek05.backend.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private Long comId;

    @Column(name = "about")
    private String about;

    @Column(name = "comp_name")
    private String compName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "web_url")
    private String webUrl;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	/**
	 * @param comId
	 * @param about
	 * @param compName
	 * @param email
	 * @param phone
	 * @param webUrl
	 * @param address
	 * @param jobs
	 */
	public Company(Long comId, String about, String compName, String email, String phone, String webUrl,
			Address address, List<Job> jobs) {
		super();
		this.comId = comId;
		this.about = about;
		this.compName = compName;
		this.email = email;
		this.phone = phone;
		this.webUrl = webUrl;
		this.address = address;
		this.jobs = jobs;
	}

	/**
	 * 
	 */
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Company [comId=" + comId + ", about=" + about + ", compName=" + compName + ", email=" + email
				+ ", phone=" + phone + ", webUrl=" + webUrl + ", address=" + address + ", jobs=" + jobs + "]";
	}
    
    
}
