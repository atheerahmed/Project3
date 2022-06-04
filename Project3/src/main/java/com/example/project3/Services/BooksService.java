package com.example.project3.Services;

import com.example.project3.Models.*;
import com.example.project3.MyExption.InvalidIdException;
import com.example.project3.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BookRepository bookRepository;
    private final MyUserServices myUserServices;
    private final LoanService loanService;

    public List<Books> getBooks(){
        return bookRepository.findAll();

    }
    public void addBook(Books book){
        bookRepository.save(book);
    }

    public Books getBookById(Integer bookId) throws InvalidIdException {
        return bookRepository.findById(bookId)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid BookID"));
    }
    //Q1
    public void addLoan(Integer userId, Integer bookId) throws InvalidIdException {
        Books book=getBookById(bookId);
        MyUesr myUesr=myUserServices.getUserById(userId);

        myUesr.getBooks().add(book);
        myUserServices.addUser(myUesr);

        Loan loan=new Loan(null,bookId,userId);
        loan.getBooks().add(book);
        loanService.addLoan(loan);

    }



}
