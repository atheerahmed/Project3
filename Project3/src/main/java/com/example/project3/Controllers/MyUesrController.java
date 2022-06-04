package com.example.project3.Controllers;

import com.example.project3.DTO.API;
import com.example.project3.Models.MyUesr;
import com.example.project3.MyExption.InvalidIdException;
import com.example.project3.Services.MyUserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@AllArgsConstructor
public class MyUesrController {
    private final MyUserServices myUserServices;

    @GetMapping
    public ResponseEntity<List<MyUesr>> getUsers(){
        return ResponseEntity.status(200).body(myUserServices.getUsers());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<MyUesr> getUserById(@PathVariable Integer id) throws InvalidIdException {
        return ResponseEntity.status(200).body(myUserServices.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<API> addUser(@RequestBody MyUesr myUesr){
        myUserServices.addUser(myUesr);
        return ResponseEntity.status(200).body(new API("Added new user ",200));

    }





}
