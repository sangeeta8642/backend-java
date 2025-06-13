package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.DTOs.UserDTOs.UserResDTO;
import com.scrub.pro.scrubPro.Models.Stagged_User;
import com.scrub.pro.scrubPro.Models.Users;
import com.scrub.pro.scrubPro.Services.StaggedUserService;
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
    private final StaggedUserService staggedUserService;


    public UserController(UserService userService, StaggedUserService staggedUserService) {
        this.userService = userService;
        this.staggedUserService = staggedUserService;
    }

    @GetMapping
    public List<UserResDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Stagged_User>> createUser(@RequestBody @Valid CreateUserDTO dto) {
//        Stagged_User createdUser = userService.createUser(dto);
        System.out.println("UserData " + dto.getUserName() + " " + dto.getEmail() + " " + dto.getPassword() + " " + dto.getRoleId());
        Stagged_User createdUser = staggedUserService.createStaggedUser(dto);
        ApiResponseDTO<Stagged_User> res = new ApiResponseDTO<Stagged_User>(true, "User Created Successfully", createdUser);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponseDTO<Stagged_User>> updateUser(@PathVariable int userId, @RequestBody @Valid CreateUserDTO dto) {
        Stagged_User updatedUser = staggedUserService.updateStaggedUser(userId, dto);
        ApiResponseDTO<Stagged_User> res = new ApiResponseDTO<Stagged_User>(true, "User Update Successfully", updatedUser);
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
