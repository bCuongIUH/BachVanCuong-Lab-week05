package vn.edu.iuh.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "jobDesc", columnDefinition = "TEXT")
    private String jobDesc;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "job")
    private List<JobSkill> jobSkills;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<JobSkill> getJobSkills() {
		return jobSkills;
	}

	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}

	/**
	 * @param jobId
	 * @param jobName
	 * @param jobDesc
	 * @param company
	 * @param jobSkills
	 */
	public Job(Long jobId, String jobName, String jobDesc, Company company, List<JobSkill> jobSkills) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDesc = jobDesc;
		this.company = company;
		this.jobSkills = jobSkills;
	}

	/**
	 * 
	 */
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", jobDesc=" + jobDesc + ", company=" + company
				+ ", jobSkills=" + jobSkills + "]";
	}

    
    
}
