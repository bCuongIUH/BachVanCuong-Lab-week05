package vn.edu.iuh.fit.labweek05.backend.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private Long expId;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "role")
    private String role;

    @Column(name = "company")
    private String company;

    @Column(name = "work_desc", columnDefinition = "TEXT")
    private String workDesc;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

	public Long getExpId() {
		return expId;
	}

	public void setExpId(Long expId) {
		this.expId = expId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * @param expId
	 * @param fromDate
	 * @param toDate
	 * @param role
	 * @param company
	 * @param workDesc
	 * @param candidate
	 */
	public Experience(Long expId, LocalDate fromDate, LocalDate toDate, String role, String company, String workDesc,
			Candidate candidate) {
		super();
		this.expId = expId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.role = role;
		this.company = company;
		this.workDesc = workDesc;
		this.candidate = candidate;
	}

	/**
	 * 
	 */
	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Experience [expId=" + expId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", role=" + role
				+ ", company=" + company + ", workDesc=" + workDesc + ", candidate=" + candidate + "]";
	}
    
    
}
