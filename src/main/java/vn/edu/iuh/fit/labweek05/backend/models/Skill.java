package vn.edu.iuh.fit.labweek05.backend.models;

import jakarta.persistence.*;

import vn.edu.iuh.fit.labweek05.backend.enums.SkillType;

import java.util.List;


@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skillId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_desc", columnDefinition = "TEXT")
    private String skillDesc;

    @Column(name = "skill_type")
    @Enumerated(EnumType.ORDINAL)
    private SkillType skillType;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public List<JobSkill> getJobSkills() {
		return jobSkills;
	}

	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}

	/**
	 * @param skillId
	 * @param skillName
	 * @param skillDesc
	 * @param skillType
	 * @param jobSkills
	 */
	public Skill(Long skillId, String skillName, String skillDesc, SkillType skillType, List<JobSkill> jobSkills) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillDesc = skillDesc;
		this.skillType = skillType;
		this.jobSkills = jobSkills;
	}

	/**
	 * 
	 */
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", skillDesc=" + skillDesc + ", skillType="
				+ skillType + ", jobSkills=" + jobSkills + "]";
	}
    
    
    
    
}
