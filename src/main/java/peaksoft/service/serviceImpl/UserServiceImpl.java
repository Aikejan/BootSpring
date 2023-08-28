package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.User;
import peaksoft.repository.Userrepository;
import peaksoft.service.UserService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor   // DI DEPENDENSY INGECTION  VNEDRENIE ZAVISIMOSTI SLABO ZAVISIMY
public class UserServiceImpl implements UserService {

    private final Userrepository userrepository;

    @Override
    public void saveUser(User user) {
        userrepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userrepository.findById(id).orElseThrow(
                () -> new NullPointerException("User with id" + id + " is not found")
        );
    }

    @Override
    public void updateUser(Long id, User user) {
        User user1 = getUserById(id);
        user1.setFirstName(user1.getFirstName());
        user1.setLastName(user1.getLastName());
        user1.setAge(user1.getAge());
        user1.setEmail(user1.getEmail());
        userrepository.save(user1);

    }

    @Override
    public void deleteUser(Long id) {
        if (userrepository.existsById(id)) {
            userrepository.deleteById(id);
        } else throw new NullPointerException(
                "User with id: " + id + "doesn't exsist"
        );

    }

    @Override
    public User getUserByEmail(String email) {
        return userrepository.getUserByEmail(email);
    }
}
