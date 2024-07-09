package com.fabrixbau.apiREST.dao.imp;

import com.fabrixbau.apiREST.dao.PermissionDao;
import com.fabrixbau.apiREST.models.Permission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PermissionDaoImp implements PermissionDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Permission> getAll() {
        String hql = "FROM Permission as u ";
        return (List<Permission>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Permission get(long id) {
        return entityManager.find(Permission.class, id);
    }

    @Transactional
    @Override
    public Permission register(Permission permission) {
        entityManager.merge(permission);
        return permission;
    }

    @Transactional
    @Override
    public Permission update(Permission permission) {
        entityManager.merge(permission);
        return permission;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Permission permission = get(id);
        entityManager.remove(permission);
    }
}
