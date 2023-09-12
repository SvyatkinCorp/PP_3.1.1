package ru.SpringBoot.Task_PP311.service;

import org.springframework.stereotype.Component;

import ru.SpringBoot.Task_PP311.dao.UserDao;
import ru.SpringBoot.Task_PP311.model.User;

import java.util.List;
@Component
public class UserServicelmp implements UserService{

    private final UserDao userDao;

    public UserServicelmp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> GetAllListUsers() {
        return userDao.GetAllListUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserId(int id) {
        return userDao.getUserId(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserId(int id) {
        userDao.deleteUserId(id);
    }
}
