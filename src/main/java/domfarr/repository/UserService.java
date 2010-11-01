package domfarr.repository;

import domfarr.model.User;

import java.util.List;

public interface UserService {

    public User getUser(String id);

    public List getUsers();

    public void addUser(User user);
}
