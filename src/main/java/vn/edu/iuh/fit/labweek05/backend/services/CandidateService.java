package vn.edu.iuh.fit.labweek05.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.labweek05.backend.models.Address;
import vn.edu.iuh.fit.labweek05.backend.models.Candidate;
import vn.edu.iuh.fit.labweek05.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.labweek05.backend.repositories.CandidateRepository;

import java.time.LocalDate;

@Service
public class CandidateService {
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	AddressRepository addressRepository;

	public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
		Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		return candidateRepository.findAll(pageable);
	}

	public void addCandidate(String fullName, String phone, String email, LocalDate dob, String city, String number,
			String zipcode, String street, String country) {

		Address address = new Address();
		address.setCity(city);
		address.setNumber(number);
		address.setZipcode(zipcode);
		address.setStreet(street);
		address.setCountry(Integer.parseInt(country));
		addressRepository.save(address);


		Candidate candidate = new Candidate();
		candidate.setFullName(fullName);
		candidate.setDob(dob);
		candidate.setAddress(address);
		candidate.setPhone(phone);
		candidate.setEmail(email);
		candidateRepository.save(candidate);
	}

	public Candidate getCandidateById(Long id) {
		return candidateRepository.findByCanId(id);
	}

	public void updateCandidate(String canId, String fullName, String phone, String email, LocalDate dob, String addId,
			String city, String number, String zipcode, String street, String country) {
		Address address = addressRepository.findById(Long.parseLong(addId)).get();
		address.setCity(city);
		address.setNumber(number);
		address.setZipcode(zipcode);
		address.setStreet(street);
		address.setCountry(Integer.parseInt(country));

		addressRepository.save(address);

		Candidate candidate = getCandidateById(Long.parseLong(canId));
		candidate.setFullName(fullName);
		candidate.setDob(dob);
		candidate.setAddress(address);
		candidate.setPhone(phone);
		candidate.setEmail(email);

		candidateRepository.save(candidate);

	}

	public void deleteCandidate(Long id) {
		Candidate candidate = getCandidateById(id);
		candidateRepository.delete(candidate);
	}
}
