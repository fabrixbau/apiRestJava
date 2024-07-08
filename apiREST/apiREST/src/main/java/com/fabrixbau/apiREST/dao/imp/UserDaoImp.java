package com.fabrixbau.apiREST.dao.imp;

import com.fabrixbau.apiREST.dao.UserDao;
import com.fabrixbau.apiREST.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String hql = "FROM User as u";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User post(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delete(long id) {
        User user = get(id);
        entityManager.remove(user);
    }
}
