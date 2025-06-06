package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.RoleDTOs.CreateRoleDTO;
import com.scrub.pro.scrubPro.Models.Role;
import com.scrub.pro.scrubPro.Repositories.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> getAllUsers() {
        return roleRepo.findAll();
    }

    public Role getRole(int roleId) {
        return roleRepo.findById(roleId).orElse(null);
    }

    public Role createRole(CreateRoleDTO roleDTO) {

        Role role = new Role();

        role.setTitle(roleDTO.getTitle());

        return roleRepo.save(role);
    }

    public Role updateRole(int roleId, CreateRoleDTO roleDTO) {
        Role role = roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException("No Role Found"));
//        Role role = new Role();
        role.setTitle(roleDTO.getTitle());
        return roleRepo.save(role);
    }

    public boolean deleteRole(int roleId){
        if(!roleRepo.existsById(roleId)){
//            throw new RuntimeException("Role Not Found");
            return false;
        }
        roleRepo.deleteById(roleId);
        return true;
    }
}
