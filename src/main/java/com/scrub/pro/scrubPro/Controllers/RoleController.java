package com.scrub.pro.scrubPro.Controllers;

import com.scrub.pro.scrubPro.DTOs.ApiResponseDTO;
import com.scrub.pro.scrubPro.DTOs.RoleDTOs.CreateRoleDTO;
import com.scrub.pro.scrubPro.Models.Role;
import com.scrub.pro.scrubPro.Services.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllUsers();
    }

    @GetMapping("/{roleId}")
    public Role getUser(@PathVariable int roleId) {
        return roleService.getRole(roleId);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Role>> createRole(@RequestBody @Valid CreateRoleDTO dto) {
        Role createRole = roleService.createRole(dto);
        ApiResponseDTO<Role> res = new ApiResponseDTO<Role>(true, "Role Created Successfully", createRole);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<ApiResponseDTO<Role>> updateUser(@PathVariable int roleId, @RequestBody @Valid CreateRoleDTO dto) {
        Role updatedRole = roleService.updateRole(roleId, dto);
        ApiResponseDTO<Role> res = new ApiResponseDTO<Role>(true, "User Update Successfully", updatedRole);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteUser(@PathVariable int roleId) {
        boolean roleDeleted = roleService.deleteRole(roleId);
        if (roleDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Role Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Role Deletion Failed");
    }

}
