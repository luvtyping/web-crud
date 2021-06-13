package crud.web.dao;

import crud.web.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUser(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
