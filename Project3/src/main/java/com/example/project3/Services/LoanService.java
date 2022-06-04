package com.example.project3.Services;

import com.example.project3.Models.Books;
import com.example.project3.Models.Loan;
import com.example.project3.Models.MyUesr;
import com.example.project3.MyExption.InvalidIdException;
import com.example.project3.Repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final BooksService booksService;


    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    public void addLoan(Loan loan){
        loanRepository.save(loan);
    }

    public Loan findLoanById(Integer id){
        return loanRepository.findById(id).get();
    }
//Q2
    public Books findBookById(Integer bookId) throws InvalidIdException {

        Books books = booksService.getBookById(bookId);
        for (Loan loan:getLoans()) {
            if (loan.getBookid().equals(bookId))
                return books;

        }
        return null;
    }


}
