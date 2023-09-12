package ru.SpringBoot.Task_PP311.dao;

import org.springframework.stereotype.Repository;


import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import ru.SpringBoot.Task_PP311.model.User;


import java.util.List;


@Repository
public class  UserDaolmp implements UserDao{

//    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> GetAllListUsers() {
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.id", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User getUserId(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserId(int id) {
        final User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
