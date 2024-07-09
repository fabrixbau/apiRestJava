package com.fabrixbau.apiREST.controllers;

import com.fabrixbau.apiREST.models.Permission;
import com.fabrixbau.apiREST.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    // Trae todos los permissions
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permission> getAll() {
        return permissionService.getAll();
    }

    // Trae todos los permissions
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permission get(@PathVariable long id) {
        return permissionService.get(id);
    }

    // Registrar permission
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permission register(@RequestBody Permission permission) {
        return permissionService.register(permission);
    }

    // Registrar permission
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permission update(@RequestBody Permission permission) {
        return permissionService.update(permission);
    }

    // Registrar permission
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        permissionService.delete(id);
    }
}

