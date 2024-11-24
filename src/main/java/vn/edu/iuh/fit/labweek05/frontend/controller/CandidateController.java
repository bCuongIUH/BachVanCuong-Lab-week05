package vn.edu.iuh.fit.labweek05.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.labweek05.backend.models.Candidate;
import vn.edu.iuh.fit.labweek05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.labweek05.backend.services.CandidateService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }

    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage= candidateService.findAll(
                currentPage - 1,pageSize,"canId","asc");


        model.addAttribute("candidatePage", candidatePage);

        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }


    @GetMapping("/add-form")
    public String showFormAdd(){
        return "candidates/add-candidate";
    }

    @PostMapping("/add")
    public String addCandidate( @RequestParam String fullName,
                                @RequestParam String phone,
                                @RequestParam String email,
                                @RequestParam LocalDate dob,
                                @RequestParam String city,
                                @RequestParam String number,
                                @RequestParam String zipcode,
                                @RequestParam String street,
                                @RequestParam String country
                               ){

        candidateService.addCandidate(fullName, phone, email, dob, city, number, zipcode, street, country);
        return "redirect:/list";
    }

    @GetMapping("/update-form/{id}")
    public String showFormAdd(Model model, @PathVariable Long id){
        Candidate candidate = candidateService.getCandidateById(id);
        model.addAttribute("candidate", candidate);
        model.addAttribute("address", candidate.getAddress());

        return "candidates/update-candidates";
    }

    @PostMapping("/update")
    public String updateCandidate(
            @RequestParam String canId,
            @RequestParam String fullName,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam LocalDate dob,
            @RequestParam String addId,
            @RequestParam String city,
            @RequestParam String number,
            @RequestParam String zipcode,
            @RequestParam String street,
            @RequestParam String country
    ){
        candidateService.updateCandidate(canId, fullName, phone, email, dob, addId,
                city, number, zipcode, street, country);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id){
        candidateService.deleteCandidate(id);
        return "redirect:/list";
    }
}
