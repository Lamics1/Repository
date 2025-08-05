package com.example.usersmanagementsoftware.Controller;

import com.example.usersmanagementsoftware.Api.ApiResponse;
import com.example.usersmanagementsoftware.Model.User;
import com.example.usersmanagementsoftware.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
final private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(404).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully "));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateUser(@PathVariable Integer id ,@Valid @RequestBody User user , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(404).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }

    @GetMapping("get-user-by-email/{email}")
    public ResponseEntity<?>getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get-by-role/{role}")
    public ResponseEntity<?>getUserByRole(@PathVariable String role){
        return ResponseEntity.status(200).body(userService.getUserByRole(role));
    }

    @GetMapping("/get-by-age/{age}")
    public ResponseEntity<?>getUserByAge(@PathVariable Integer age){
        return ResponseEntity.status(200).body(userService.getUserByAge(age));
    }
    @GetMapping("/logIn/{username}/{password}")
    public ResponseEntity<?>getUserByUsernameAndPassword(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(userService.getUserByUsernameAndPassword(username,password));
    }

}
