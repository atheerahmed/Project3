package com.example.project3.Controllers;

import com.example.project3.Models.Books;
import com.example.project3.Models.Loan;
import com.example.project3.MyExption.InvalidIdException;
import com.example.project3.Services.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    Logger logger= LoggerFactory.getLogger(LoanController.class);

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("Request in get Loans");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(Integer id){
        logger.info("Request in get Loan By Id");
        return ResponseEntity.status(200).body(loanService.findLoanById(id));
    }


    @PostMapping
    public ResponseEntity addLoan(@RequestBody @Valid Loan loan){
        logger.info("Request in add Loan");
        loanService.addLoan(loan);
        return ResponseEntity.status(200).body("Added new Loan");
    }
//Q2
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Books> getBookById(Integer bookId) throws InvalidIdException {
        logger.info("Request in get book By Id");
        return ResponseEntity.status(200).body(loanService.findBookById(bookId));
    }


}
