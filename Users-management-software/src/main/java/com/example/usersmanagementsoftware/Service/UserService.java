package com.example.usersmanagementsoftware.Service;

import com.example.usersmanagementsoftware.Api.ApiException;
import com.example.usersmanagementsoftware.Model.User;
import com.example.usersmanagementsoftware.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

final private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }
    public void updateUser(Integer id , User user){
     User oldUser =userRepository.findUserById(id);
     if (oldUser == null){
         throw new ApiException("User not found");
     }
     oldUser.setAge(user.getAge());
     oldUser.setRole(user.getRole());
     oldUser.setEmail(user.getEmail());
     oldUser.setPassword(user.getPassword());
     oldUser.setUsername(user.getUsername());
     oldUser.setName(user.getName());
     userRepository.save(oldUser);
    }

    public void deleteUser(Integer id){
    User oldUser = userRepository.giveMeById(id);
    if (oldUser == null){
        throw new ApiException("user not found");
    }
    userRepository.delete(oldUser);
    }

    public User getUserByEmail(String email){
     User oldUser = userRepository.findUserByEmail(email);
     if (oldUser == null){
         throw new ApiException("User not found");

     }
     return oldUser;
    }

    public List<User> getUserByRole(String role){
     List<User> oldUser = userRepository.giveMeByRole(role);
     if (oldUser == null){
         throw new ApiException("Role not found");
     }
     return oldUser;
    }

    public List<User> getUserByAge(Integer age){
        List<User> oldUser =userRepository.giveMeByAge(age);
        if (oldUser == null){
            throw new ApiException("Age not found");
        }
        return oldUser;
    }

    public User getUserByUsernameAndPassword(String username,String password){
        User oldUser =userRepository.findUserByUsernameAndPassword(username,password);
        if (oldUser == null){
            throw new ApiException("username inCorrect or Password inCorrect");
        }
        return oldUser;
    }

}
