package com.fabrixbau.apiREST.services;

import com.fabrixbau.apiREST.dao.PermissionDao;
import com.fabrixbau.apiREST.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    PermissionDao permissionDao;

    public List<Permission> getAll() {
        return permissionDao.getAll();
    }

    public Permission get(long id) {
        return permissionDao.get(id);
    }

    public Permission register(Permission permission) {
        return permissionDao.register(permission);
    }

    public Permission update(@RequestBody Permission permission) {
        return permissionDao.update(permission);
    }

    public void delete(@PathVariable long id) {
        permissionDao.delete(id);
    }
}
