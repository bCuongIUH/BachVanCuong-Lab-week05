package vn.edu.iuh.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.labweek05.backend.models.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByCanId(Long id);

}
