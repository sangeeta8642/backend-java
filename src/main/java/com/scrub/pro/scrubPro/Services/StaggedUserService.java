package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.Models.Role;
import com.scrub.pro.scrubPro.Models.Stagged_User;
import com.scrub.pro.scrubPro.Models.Users;
import com.scrub.pro.scrubPro.Repositories.RoleRepo;
import com.scrub.pro.scrubPro.Repositories.StaggedUserRepo;
import com.scrub.pro.scrubPro.Repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaggedUserService {
    private final RoleRepo roleRepo;
    private final StaggedUserRepo staggedUserRepo;
    private final PasswordEncoder passwordEncoder;

    public StaggedUserService(RoleRepo roleRepo, StaggedUserRepo staggedUserRepo,PasswordEncoder passwordEncoder) {
        this.roleRepo = roleRepo;
        this.staggedUserRepo = staggedUserRepo;
        this.passwordEncoder=passwordEncoder;
    }

    public List<Stagged_User> getAllStaggedUsers() {
        return staggedUserRepo.findAll();
    }

    public Stagged_User getStaggedUser(int userId) {
        return staggedUserRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Stagged_User createStaggedUser(CreateUserDTO userDTO) {
        System.out.println("userDTO : "+userDTO.getEmail()+" "+userDTO.getUserName()+" "+userDTO.getRoleId()+" "+userDTO.getPassword());
        Role role = roleRepo.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role Not Found"));
//        Role role = roleRepo.findByTitle(userDTO.getRoleId())
//                .orElseThrow(() -> new RuntimeException("Role Not Found"));

//        if(userRepo.existingByEmail(userDTO.getEmail())){
//            return
//        }

        Stagged_User user = new Stagged_User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(role);

        return staggedUserRepo.save(user);
    }

    public Stagged_User updateStaggedUser(int userId, CreateUserDTO userDTO) {
        Stagged_User user = staggedUserRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepo.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail()); // Correct property assignment
        user.setPassword(userDTO.getPassword());
        user.setRole(role);

        return staggedUserRepo.save(user);
    }

    public boolean deleteStaggedUser(int userId) {
        if (!staggedUserRepo.existsById(userId)) {
            throw new RuntimeException("User not found");
//            return false;
        }
        staggedUserRepo.deleteById(userId);
        return true;
    }
}
