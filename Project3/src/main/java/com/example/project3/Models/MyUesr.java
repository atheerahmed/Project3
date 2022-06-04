package com.example.project3.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class MyUesr{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID is required ")
    private Integer id;
    @NotEmpty(message = "Username is required ")
    private String username;
    @NotEmpty(message = "Password is required ")
    private String password;

    @OneToMany(mappedBy = "myUesr",cascade = CascadeType.ALL)
    private Set<Books> books;

    public void addBook(Books book){
        books.add(book);
    }

}
