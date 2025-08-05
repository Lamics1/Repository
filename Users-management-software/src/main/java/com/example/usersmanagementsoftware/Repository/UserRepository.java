package com.example.usersmanagementsoftware.Repository;

import com.example.usersmanagementsoftware.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

User findUserById(Integer id);


@Query("select u FROM User u where u.id =?1")
User giveMeById(Integer id);


User findUserByEmail(String email);

@Query("select r from User r where r.role =?1")
List<User> giveMeByRole(String role);


@Query("select a from User a where a.age >=?1")
List<User>giveMeByAge(Integer age);

//
//@Query("select p from User p where p.username =?1 AND p.password=?2")
//List<User> giveMeUsernameAndPassword(String username,String password);

    User findUserByUsernameAndPassword(String username, String password);
}
