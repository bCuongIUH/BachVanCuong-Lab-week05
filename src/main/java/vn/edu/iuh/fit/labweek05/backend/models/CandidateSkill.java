package vn.edu.iuh.fit.labweek05.backend.models;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.labweek05.backend.enums.SkillLevel;


@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {

    @Column(name = "skill_level")
    @Enumerated(EnumType.ORDINAL)
    private SkillLevel skillLevel;

    @Column(name = "more_infos", columnDefinition = "TEXT")
    private String moreInfos;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @Id
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    @Id
    private Skill skill;

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

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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
	 * @param candidate
	 * @param skill
	 */
	public CandidateSkill(SkillLevel skillLevel, String moreInfos, Candidate candidate, Skill skill) {
		super();
		this.skillLevel = skillLevel;
		this.moreInfos = moreInfos;
		this.candidate = candidate;
		this.skill = skill;
	}

	/**
	 * 
	 */
	public CandidateSkill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CandidateSkill [skillLevel=" + skillLevel + ", moreInfos=" + moreInfos + ", candidate=" + candidate
				+ ", skill=" + skill + "]";
	}


}
