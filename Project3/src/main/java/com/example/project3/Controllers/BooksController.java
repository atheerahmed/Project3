package com.example.project3.Controllers;

import com.example.project3.DTO.BookDTO;
import com.example.project3.Models.Books;
import com.example.project3.MyExption.InvalidIdException;
import com.example.project3.Services.BooksService;
import com.example.project3.Services.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;
    private final LoanService loanService;
    Logger logger= LoggerFactory.getLogger(BooksController.class);

    @GetMapping
    public ResponseEntity<List<Books>> getBooks(){
        logger.info("Request in get Books");
        return ResponseEntity.status(200).body(booksService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id) throws InvalidIdException {
        logger.info("Request in get Book By Id");
        return ResponseEntity.status(200).body(booksService.getBookById(id));
    }
//Q1
    @PostMapping("/loan/{userId}/{bookId}")
    public ResponseEntity addLoan(@PathVariable Integer userId , @PathVariable Integer bookId) throws InvalidIdException {
        logger.info("Request in add Loan");
        booksService.addLoan(userId,bookId);
        return ResponseEntity.status(200).body(" Create new loan ");
    }



}
