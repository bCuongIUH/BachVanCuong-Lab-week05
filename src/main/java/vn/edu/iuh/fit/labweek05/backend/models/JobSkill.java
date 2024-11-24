package vn.edu.iuh.fit.labweek05.backend.models;

import jakarta.persistence.*;

import vn.edu.iuh.fit.labweek05.backend.enums.SkillLevel;


@Entity
@Table(name = "job_skill")
public class JobSkill {

    @Column(name = "skill_level")
    @Enumerated(EnumType.ORDINAL)
    private SkillLevel skillLevel;

    @Column(name = "more_infos", columnDefinition = "TEXT")
    private String moreInfos;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @Id
    private Job job;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    @Id
    private Skill skill;
    
    public JobSkill() {
    	
    }

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getMoreInfos() {
		return moreInfos;
	}

	public void setMoreInfos(String moreInfos) {
		this.moreInfos = moreInfos;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	/**
	 * @param skillLevel
	 * @param moreInfos
	 * @param job
	 * @param skill
	 */
	public JobSkill(SkillLevel skillLevel, String moreInfos, Job job, Skill skill) {
		super();
		this.skillLevel = skillLevel;
		this.moreInfos = moreInfos;
		this.job = job;
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "JobSkill [skillLevel=" + skillLevel + ", moreInfos=" + moreInfos + ", job=" + job + ", skill=" + skill
				+ "]";
	}
    
}
