package com.abhi.SpringBootMVC.Repositry;

import com.abhi.SpringBootMVC.Model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
}
