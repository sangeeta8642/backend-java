package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.Models.Users;
import com.scrub.pro.scrubPro.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Users>> createUser(@RequestBody @Valid CreateUserDTO dto) {
        Users createdUser = userService.createUser(dto);
        ApiResponseDTO<Users> res = new ApiResponseDTO<Users>(true, "User Created Successfully", createdUser);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponseDTO<Users>> updateUser(@PathVariable int userId, @RequestBody @Valid CreateUserDTO dto) {
        Users updatedUser = userService.updateUser(userId, dto);
        ApiResponseDTO<Users> res = new ApiResponseDTO<Users>(true, "User Update Successfully", updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        boolean userDeleted = userService.deleteUser(userId);
        if (userDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User Deletion Failed");
    }
}
