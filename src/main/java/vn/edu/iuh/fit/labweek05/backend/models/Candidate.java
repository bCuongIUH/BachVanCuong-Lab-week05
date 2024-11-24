package vn.edu.iuh.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private Long canId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private LocalDate dob;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills;

	public Long getCanId() {
		return canId;
	}

	public void setCanId(Long canId) {
		this.canId = canId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<CandidateSkill> getCandidateSkills() {
		return candidateSkills;
	}

	public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
		this.candidateSkills = candidateSkills;
	}

	/**
	 * 
	 */
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String fullName, LocalDate dob, Address address, String phone, String email) {
	    this.fullName = fullName;
	    this.dob = dob;
	    this.address = address;
	    this.phone = phone;
	    this.email = email;
	}


	@Override
	public String toString() {
		return "Candidate [canId=" + canId + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email
				+ ", dob=" + dob + ", address=" + address + ", experiences=" + experiences + ", candidateSkills="
				+ candidateSkills + "]";
	}
    
    
}
