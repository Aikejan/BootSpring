package peaksoft.service;

import peaksoft.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
     void  updateUser(Long id, User user);
     void deleteUser(Long id);
     User getUserByEmail(String email);  // BUL METOD VSTOENNIY EMES OZUBUZ TUZGON METOD
}
