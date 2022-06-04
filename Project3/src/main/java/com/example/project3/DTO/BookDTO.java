package com.example.project3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookDTO {
    private Integer bookId;
    private Integer userId;
    private String name;
    private String genre;
}
