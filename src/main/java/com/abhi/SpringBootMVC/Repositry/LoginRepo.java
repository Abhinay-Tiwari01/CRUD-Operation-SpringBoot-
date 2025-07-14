package com.abhi.SpringBootMVC.Repositry;

import com.abhi.SpringBootMVC.Model.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<com.abhi.SpringBootMVC.Model.LoginEntity, Integer> {
    LoginEntity findByUserNameAndPassword(String userName, String password);

    LoginEntity findBymobile(String mobile);

}
