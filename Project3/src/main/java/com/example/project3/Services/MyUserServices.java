package com.example.project3.Services;

import com.example.project3.Models.MyUesr;
import com.example.project3.MyExption.InvalidIdException;
import com.example.project3.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserServices {
    private final MyUserRepository myUserRepository;


    public List<MyUesr> getUsers(){
       return myUserRepository.findAll();
    }
    public void addUser(MyUesr myUesr){
        myUserRepository.save(myUesr);
    }
    public MyUesr getUserById(Integer id) throws InvalidIdException {
        return myUserRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid ID"));
    }
}
