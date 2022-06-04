package com.example.project3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Loan {
    @Id
    @NotNull(message = "ID required")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Book ID required")
    private Integer bookid;
    @NotNull(message = "User ID required")
    private Integer userid;
    @ManyToMany(mappedBy = "loans", cascade = CascadeType.ALL)
    @JsonIgnore
     private Set<Books> books;

    public Loan(Integer id, Integer bookid, Integer userid) {
        this.id = id;
        this.bookid = bookid;
        this.userid = userid;
    }

    public void addBook(Books book){
        books.add(book);
    }
}
