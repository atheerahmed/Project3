package com.example.project3.Repository;

import com.example.project3.Models.MyUesr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUesr,Integer> {
}
