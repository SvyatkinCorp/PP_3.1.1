package ru.SpringBoot.Task_PP311.service;

import ru.SpringBoot.Task_PP311.model.User;

import java.util.List;

public interface UserService {
    List<User> GetAllListUsers();
    void addUser(User user);
    User getUserId(int id);
    void updateUser(User user);
    void deleteUserId(int id);
}
