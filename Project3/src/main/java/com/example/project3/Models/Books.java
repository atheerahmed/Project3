package com.example.project3.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data  @NoArgsConstructor @AllArgsConstructor
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID required")
    private Integer id;
    @NotEmpty(message = "Name required")
    private String name;
    @NotEmpty(message = "Genre required")
    private String genre;
    @ManyToOne
    @JsonIgnore
    private MyUesr myUesr;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Loan> loans;

    public Books( String name, String genre, MyUesr myUesr) {

        this.name = name;
        this.genre = genre;
        this.myUesr = myUesr;
    }
}
